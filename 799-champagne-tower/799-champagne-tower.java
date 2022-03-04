class Solution {
    public double champagneTower(int c, int n, int m) {
        double dp[][]=new double[n+1][m+2];//simulating the process take 1 unit and distribute (add) /2 of remaining to left and right
        dp[0][0]=c;
        for(int i=0;i<n;i++){
            for(int j=0;j<=m;j++){
                double rest=Math.max(0.0,dp[i][j]-1.0);
                dp[i+1][j]+=rest/2.0;//as in array it weill be like right angle triangle not pyramid
                dp[i+1][j+1]+=rest/2.0;
            }
        }
        return Math.min(dp[n][m],1.0);
    }
}