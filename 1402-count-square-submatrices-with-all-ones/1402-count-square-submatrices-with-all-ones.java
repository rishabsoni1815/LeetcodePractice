class Solution {
    public int countSquares(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int dp[][]=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1) dp[i][j]=1;
                if(a[i][j]==1 && i-1>=0 && j-1>=0 && a[i-1][j]==1 && a[i][j-1]==1 && a[i-1][j-1]==1){
                    dp[i][j] += Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
                ans+=dp[i][j];
            }
        }
        return ans;
    }
}