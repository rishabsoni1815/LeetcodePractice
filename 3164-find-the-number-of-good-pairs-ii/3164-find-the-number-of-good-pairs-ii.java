class Solution {

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> nm = new HashMap<>();
        for(int i : nums2)
        {
            int val = i * k;
            nm.put(val, nm.getOrDefault(val, 0) + 1);
        }
        long ans=0;
        for(int i : nums1)
        {
            for(int j=1;j*j<=i;j++)
            {
                if(i%j==0)
                {
                    if(nm.containsKey(j))
                    {
                        ans += nm.get(j);
                    }
                    int val=i/j;
                    if(j!=val && nm.containsKey(val))
                    {
                        ans += nm.get(val);
                    }
                }
            }
        }
        return ans;
    }
    
    //still giving tle so using methoid of finding factors of a[i] and matching with b[i]*k as if a[i] is divible by b[i]*k then this must be factor of a[i]
    //     public long numberOfPairs(int[] a, int[] b, int k) {
//         // a[i] is divisible by (b[i]*k) also a[i]/k is divisible by b[i] so we can get multiples of every b[i] and check freq of them which match any of the a[i]/k as if b[i] divides (a[i]*k) then this must be its multiple
        
//         HashMap<Integer,Integer>h=new HashMap<>();//map of a[i]/k
//         int n=a.length,m=b.length,max=0;
//         for(int i=0;i<n;i++){
//             if(a[i]%k!=0) continue;//a[i] is also divisible by k if (a[i]%(k*b[i] == 0)
//             int c=(a[i]/k);
//             max=Math.max(c,max);
//             h.put(c,h.getOrDefault(c,0)+1);
//         }
//         long ans=0;
//         for(int i=0;i<m;i++){
//             for(int j=b[i];j<=(max+2);j+=b[i]){//this takes log(1e6) as its a HP till max+2 for safety if do for 1e6 always gives tle so doing till max
//                 if(h.containsKey(j)) ans+=h.get(j);
//             }
//         }
//         //so tc -> m(log(1e6))
//         return ans;
//     }
}