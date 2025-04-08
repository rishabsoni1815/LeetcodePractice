class Solution {
    public int minimumOperations(int[] a) {
        int n=a.length;
        HashMap<Integer,Integer>h=new HashMap<Integer,Integer>();
        int d=0;
        for(int i=0;i<n;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
            if(h.get(a[i])==2) d++;
        }
        int ans=0;
        for(int i=0;i<n;i+=3){
            if(d<=0) return ans;
            h.put(a[i],h.get(a[i])-1);
            if(h.get(a[i])==1) d--;
           if(i+1<n){
                h.put(a[i+1],h.get(a[i+1])-1);
                if(h.get(a[i+1])==1) d--;
                if(i+2<n) {
                    h.put(a[i+2],h.get(a[i+2])-1);
                    if(h.get(a[i+2])==1) d--;
                }
           }
            ans++;
        }
        return ans;
    }
}