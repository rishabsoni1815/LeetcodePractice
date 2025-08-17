class Solution {
    public int maxSubArray(int[] a) {
        int dp[]=new int[a.length];
        dp[0]=a[0];
        int ans=a[0];
        for(int i=1;i<a.length;i++){
            dp[i]=a[i];
            dp[i]=Math.max(dp[i],a[i]+dp[i-1]);
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}