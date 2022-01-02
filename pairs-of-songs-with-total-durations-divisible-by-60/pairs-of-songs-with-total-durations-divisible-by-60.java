class Solution {
    public int numPairsDivisibleBy60(int[] a) {
        int n=a.length;
        int ans=0;int k=60;
        int f[]=new int[k];
        for(int i=0;i<n;i++){
            int x=(k - a[i]%k +k)%k;// k-a[i]%k can be negative
            ans+=(f[x]);
            f[a[i]%k]++;
        }
        return ans;
    }
}