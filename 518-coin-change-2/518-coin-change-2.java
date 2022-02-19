class Solution {
    public int change(int amount, int[] coins) {
    int dp[][]=new int[amount+1][coins.length+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++)dp[i][j]=-1;
        }
          int minCoins = memoization(coins, amount, coins.length-1 ,dp);
        return minCoins;   
    }
    int memoization(int wt[], int w, int n,int dp[][])
    {
        if(n==0){
            if(w%wt[n]==0){
                return 1;
            }else{
                return 0;
            }
        }
        
        if (dp[w][n] != -1)
            return dp[w][n];
			
        if (wt[n] > w) 
            return dp[w][n] = 0 + memoization(wt, w - 0, n - 1,dp);
        else 
            return dp[w][n] = memoization(wt, w - 0, n - 1,dp)+ memoization(wt, w - wt[n], n,dp);
    }
}