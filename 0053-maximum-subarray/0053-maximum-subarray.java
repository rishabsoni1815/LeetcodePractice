class Solution {
    public int maxSubArray(int[] a) {
        int ans=a[0],n=a.length;
        int dp[]=new int[n];
        dp[0]=a[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(a[i],a[i]+dp[i-1]);
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}