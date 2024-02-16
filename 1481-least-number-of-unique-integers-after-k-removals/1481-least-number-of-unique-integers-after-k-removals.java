class Pair{
    int number;
    int freq;
    Pair(int number,int freq){
        this.number=number;
        this.freq=freq;
    }
}
class Solution {
    public int findLeastNumOfUniqueInts(int[] a, int k) {
        PriorityQueue<Pair>q=new PriorityQueue<>((x,y)->(x.freq-y.freq));
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<a.length;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        if(k==0) return h.size();
        for(int key:h.keySet()){
            int v=h.get(key);
            q.add(new Pair(key,v));
        }
        while(k>0){
            int cfreq=q.poll().freq;
            k-=cfreq;
            if(k<=0) return q.size()+(k==0?0:1);
        }
        return 0;
    }
}