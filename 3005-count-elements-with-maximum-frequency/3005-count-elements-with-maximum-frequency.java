class Solution {
    public int maxFrequencyElements(int[] a) {
        HashMap<Integer,Integer>h=new HashMap<>();
        int sum=1,maxfreq=0;
        for(int i=0;i<a.length;i++){ //updating maxfreq and hashmap on the go and sum 
            h.put(a[i],h.getOrDefault(a[i],0)+1);
            if(h.get(a[i])>=maxfreq){
                if(h.get(a[i])==maxfreq) sum+=maxfreq;
               else {
                   maxfreq=h.get(a[i]);
                   sum=maxfreq;
               }
            }
        }
        return sum;
    }
}