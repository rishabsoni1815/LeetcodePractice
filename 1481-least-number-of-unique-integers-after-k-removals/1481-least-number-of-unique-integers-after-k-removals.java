class Pair{
    int number;
    int freq;
    Pair(int number,int freq){
        this.number=number;
        this.freq=freq;
    }
}
class Solution {
    
    // public int findLeastNumOfUniqueInts(int[] a, int k) {
    //     PriorityQueue<Pair>q=new PriorityQueue<>((x,y)->(x.freq-y.freq));
    //     HashMap<Integer,Integer>h=new HashMap<>();
    //     for(int i=0;i<a.length;i++){
    //         h.put(a[i],h.getOrDefault(a[i],0)+1);
    //     }
    //     if(k==0) return h.size();
    //     for(int key:h.keySet()){
    //         int v=h.get(key);
    //         q.add(new Pair(key,v));
    //     }
    //     while(k>0){
    //         int cfreq=q.poll().freq;
    //         k-=cfreq;
    //         if(k<=0) return q.size()+(k==0?0:1);
    //     }
    //     return 0;
    // }
    
    
    // one thing to note is the fre of frequencies is btw 0 to n so can optimise this using tha
    public int findLeastNumOfUniqueInts(int[] a, int k) {
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<a.length;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        if(k==0) return h.size();
        int ffreq[]=new int[a.length+1];
        for(int key:h.keySet()){
            int v=h.get(key);
            ffreq[v]++;
        }
        
        int cur=0,rem=h.size();
        for(int i=1;i<ffreq.length;i++){
            if(i*ffreq[i]<=k){
                k-=i*ffreq[i];//i*ffreq[i] is the number of elements with frequency as i
                rem-=ffreq[i];
            }else{
                return rem-(k/i);
            }
        }
        return rem;
    }
}