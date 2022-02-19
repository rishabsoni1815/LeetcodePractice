class Solution {
    
    /*
    memoisation
    
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[amount+1][coins.length+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++)dp[i][j]=-1;
        }
          int minCoins = memoization(coins, amount, coins.length-1 ,dp);
        return minCoins == Integer.MAX_VALUE - 1 ? -1 : minCoins;    
    }
    int memoization(int wt[], int w, int n,int dp[][])
    {
        if(n==0){
            if(w%wt[n]==0){
                return w/wt[n];
            }else{
                return Integer.MAX_VALUE-1;
            }
        }
        
        if (dp[w][n] != -1)
            return dp[w][n];
			
        if (wt[n] > w) 
            return dp[w][n] = 0 + memoization(wt, w - 0, n - 1,dp);
        else 
            return dp[w][n] = Math.min(0 + memoization(wt, w - 0, n - 1,dp), 1 + memoization(wt, w - wt[n], n,dp));
    }
    */
    
    
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=Integer.MAX_VALUE-1;// as 1+ Int_max mmay be error
            }
        }   
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                int notTake=0+dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j){
                    take=1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(notTake,take);
            }
        }
        if(dp[coins.length-1][amount]==Integer.MAX_VALUE-1){
            return -1;
        }else{
            return dp[coins.length-1][amount];
        }
    }
    
    
}