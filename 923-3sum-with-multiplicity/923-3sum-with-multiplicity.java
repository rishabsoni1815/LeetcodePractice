class Solution {
    public int threeSumMulti(int[] a, int t) {
        HashMap<Integer,Integer>h=new HashMap<>();
        int n=a.length;
        int mod=1000000007;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int csum=a[i]+a[j];
                int req=t-csum;
                if(h.containsKey(req)){
                    ans=((ans%mod)+(h.get(req)%mod))%mod;
                }
            }
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        return (int)(ans)%mod;
    }
}