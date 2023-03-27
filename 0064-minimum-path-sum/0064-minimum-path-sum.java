class Solution {
    // public int minPathSum(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     int dp[][]=new int[n][m];
    //     dp[n-1][m-1]=grid[n-1][m-1];
    //     for(int i=n-1;i>=0;i--){
    //         for(int j=m-1;j>=0;j--){
    //             if(i==n-1&&j==m-1) continue;
    //            else if(i==n-1){
    //                 dp[i][j]=grid[i][j]+dp[i][j+1];
    //             }else if(j==m-1){
    //                 dp[i][j]=grid[i][j]+dp[i+1][j];
    //             }
    //             else dp[i][j]=grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
    //         }
    //     }
    //     return dp[0][0];
    // }
    
    //as only i+1 needed can optimise space
     public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[]=new int[m];
        dp[m-1]=grid[n-1][m-1];
        for(int i=n-1;i>=0;i--){
            int prev[]=dp;
            for(int j=m-1;j>=0;j--){
                if(i==n-1&&j==m-1) continue;
               else if(i==n-1){
                    prev[j]=grid[i][j]+prev[j+1];
                }else if(j==m-1){
                    prev[j]=grid[i][j]+dp[j];
                }
                else prev[j]=grid[i][j]+Math.min(dp[j],prev[j+1]);
            }
            dp=prev;
        }
        return dp[0];
    }
}