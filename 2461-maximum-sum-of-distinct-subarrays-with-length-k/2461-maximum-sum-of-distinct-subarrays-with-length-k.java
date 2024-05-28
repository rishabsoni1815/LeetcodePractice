class Solution {
    public long maximumSubarraySum(int[] a, int k) {
        int n=a.length;
        long sum=0,ans=0;
        int cnt=0;//denotes the elements having freq >1
        //in a window size of k h.size whould be k if < then duplicate are there
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<k;i++){
            sum+=a[i];
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        if(h.size()==k){
            ans=Math.max(sum,ans);
        }
        for(int i=k;i<n;i++){
            
            //removing a[i-k]
            sum-=a[i-k];
            h.put(a[i-k],h.get(a[i-k])-1);
            if(h.get(a[i-k])==0) h.remove(a[i-k]);

            //adding a[i]
            sum+=a[i];
            h.put(a[i],h.getOrDefault(a[i],0)+1);
            
            if(h.size()==k){
                ans=Math.max(sum,ans);
            }
        }
        return ans;
    }
}