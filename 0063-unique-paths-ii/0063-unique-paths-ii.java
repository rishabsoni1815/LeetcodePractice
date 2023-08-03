class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int i=n;i>0;i--){
            for(int j=m;j>0;j--){
                if(a[i-1][j-1]==1) {
                    dp[i][j]=0;
                    continue;
                }
                if(i==n && j==m){
                    dp[i][j]=(a[i-1][j-1]==1?(0):(1));
                }
                if(j==m||i==n){
                    if(j==m && i!=n) dp[i][j]=dp[i+1][j];
                    if(i==n && j!=m) dp[i][j]=dp[i][j+1];
                }else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[1][1];
    }
}