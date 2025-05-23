class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int n=a.length,m=a[0].length;
        int dp[][]=new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(a[i][j]==1) continue;
                if(i==n-1 && j==m-1){
                    dp[i][j]=(a[i][j]==0?1:0);
                }
                if(i+1<n) dp[i][j]=dp[i+1][j];
                if(j+1<m) dp[i][j]+=dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

/*
//memoisation
   public int uniquePathsWithObstacles(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return help(0,0,a,n,m,dp);
    }
    int help(int i,int j,int a[][],int n,int m,int dp[][]){
        if(i>=n ||j>=m || a[i][j]==1){
            return 0;
        }
        if(i==n-1 && j==m-1) {
            return (a[i][j]==0?1:0);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=help(i+1,j,a,n,m,dp)+help(i,j+1,a,n,m,dp);
    }

*/