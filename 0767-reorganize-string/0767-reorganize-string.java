class Solution {
    public String reorganizeString(String s) {
        int h[]=new int[26];
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'a']++;
        }
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(Integer.compare(y[1],x[1])));
        for(int i=0;i<26;i++){
            if(h[i]>0) q.add(new int[]{i,h[i]});
        }
        // while(q.size()>0){
        //     int v[]=q.poll();
        //     System.out.println(v[0]+" "+v[1]);
        // }
        StringBuilder ans=new StringBuilder();
        while(q.size()>0){
            int c[]=q.poll();
            char cur=(char)(c[0]+'a');
            // System.out.println(cur);
            if(ans.length()>0 && ans.charAt(ans.length()-1)==cur){
                if(q.size()>0){
                    int d[]=q.poll();
                    ans.append((char)(d[0]+'a'));
                    d[1]--;
                    if(d[1]!=0) q.add(d);
                    q.add(c);
                }else{
                    return "";
                }
            }else{
                    ans.append((char)(c[0]+'a'));
                    c[1]--;
                    if(c[1]!=0) q.add(c);
            }
        }
        return ans.reverse().toString();
    }
}