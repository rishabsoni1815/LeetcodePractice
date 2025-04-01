class Solution {
    public long mostPoints(int[][] a) {
        int n=a.length;
        long dp[]=new long[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=a[i][0];
            if(a[i][1]+i+1<n) dp[i]+=(long)dp[i+1+a[i][1]];
            if(i+1<n){
                dp[i]=Math.max(dp[i],dp[i+1]);
            }
        }
        return dp[0];
    }
}