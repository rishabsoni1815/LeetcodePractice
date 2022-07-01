class Solution {
    public int coinChange(int[] a, int t) {
         int n=a.length;
        int dp[][]=new int[n+1][t+1];
        for(int i=0;i<=t;i++) dp[0][i]=Integer.MAX_VALUE-1;
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=t;j++){
                int nt=dp[i-1][j];
                int ta=Integer.MAX_VALUE-1;
                if(j-a[i-1]>=0) ta=1+dp[i][j-a[i-1]];
                dp[i][j]=Math.min(ta,nt);
            }
        }
        int ans=dp[n][t];
        return ans==Integer.MAX_VALUE-1?-1:ans;
    }
}