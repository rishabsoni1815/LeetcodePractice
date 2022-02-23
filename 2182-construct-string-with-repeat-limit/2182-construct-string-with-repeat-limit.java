class Solution {
    public String repeatLimitedString(String a, int k) {
        int h[]=new int[26];int n=a.length();
        for(int i=0;i<n;i++){
            h[a.charAt(i)-'a']++;
        }
       PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> y.ch - x.ch);//max heap
        for (int i = 0; i < h.length; ++i) {
            if (h[i] == 0) continue;
            pq.offer(new Tuple((char)(i + 'a'), h[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            Tuple t = pq.poll(); // We first poll from the PQ, get the char cloest to 'z'
            char ch = t.ch;
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=ch){
                int f=k;int cf=t.count;
                while(f-->0&&cf-->0){
                    sb.append(ch);
                }
                if(cf>0){
                     pq.offer(new Tuple(ch, cf));
                }
            }else{
                /*
                    If the current ending char is what we poll from PQ
                    We need a different char, cause we cannot use same char in a row.
				*/
                if (pq.size() == 0) break; // if there is no more chars, stop
                Tuple t2 = pq.poll();
                char ch2=t2.ch;
                sb.append(t2.ch);
                
                int count2 = t2.count;
                count2--;
                if (count2 > 0) {
                    pq.offer(new Tuple(ch2, count2));
                }
                pq.offer(t); // Remember to put the first polled Tuple back. as above if statement is not executed and we have polled t out
            }
        }
        return sb.toString();
    }
    class Tuple{
        char ch;
        int count;
        public Tuple(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}