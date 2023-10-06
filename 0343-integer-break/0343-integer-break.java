class Solution {
    public int integerBreak(int n) {
        if(n<=3) return n-1;
        int dp[]=new int[n+1];
        for(int i=1;i<=3;i++) dp[i]=i;//observation that for 1,2,3 we want dp as 1,2,3 but asn will be 0,1,2
        for(int i=4;i<=n;i++){
            int ans=0;
            for(int j=1;j<i;j++){
                ans=Math.max(ans,j*dp[i-j]);
            }
            dp[i]=ans;
        }
        return dp[n];
    }
}