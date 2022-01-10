class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[amount+1][coins.length+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++)dp[i][j]=-1;
        }
          int minCoins = memoization(coins, amount, coins.length ,dp);
        return minCoins == Integer.MAX_VALUE - 1 ? -1 : minCoins;    
    }
    int memoization(int wt[], int w, int n,int dp[][])
    {
        if (n == 0 || w == 0)
            return (w == 0) ? 0 : Integer.MAX_VALUE - 1;
        
        if (dp[w][n] != -1)
            return dp[w][n];
			
        if (wt[n - 1] > w) 
            return dp[w][n] = 0 + memoization(wt, w - 0, n - 1,dp);
        else 
            return dp[w][n] = Math.min(0 + memoization(wt, w - 0, n - 1,dp), 1 + memoization(wt, w - wt[n - 1], n,dp));
    }
    /*
     saving space as only calling dp[][n-1] and dp[][n]
     public int coinChange(int[] c, int t) {
         int n=c.length;
        int dp[][]=new int[2][t+1];
        dp[0][0]=0;
        for(int i=1;i<=t;i++){
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=t;j++){
                dp[i%2][0]=0;
                if(c[i-1]<=j){
                    dp[i%2][j]=Math.min(1+dp[i%2][j-c[i-1]],dp[(i+1)%2][j]);
                }else{
                     dp[i%2][j]=dp[(i+1)%2][j];
                }
            }
        }
        return dp[n%2][t]==Integer.MAX_VALUE-1?-1:dp[n%2][t];
    }
    
    */
}