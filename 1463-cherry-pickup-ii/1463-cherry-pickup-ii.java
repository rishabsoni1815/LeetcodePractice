class Solution {
    public int cherryPickup(int[][] a) {
         int n=a.length;
        int m=a[0].length;
        int dp[][][]=new int [n][m][m];
        // no r1,r2 as both robots row is same 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return Math.max(0,help(a,0,0,m-1,n,m,dp));
    }
     int help(int a[][],int r,int c1,int c2,int n,int m,int dp[][][]){
        if(r>=n||c1>=m||c2>=m||c1<0||c2<0){
            return Integer.MIN_VALUE;
        }
        if(r==n-1&&c1!=c2){
            return a[r][c1]+a[r][c2];
        }
        if(r==n-1&&c1==c2){
            return a[r][c1];
        }
        if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];
        int cherries=0;
        if(c1==c2){
            cherries = a[r][c1];
        }
        else{
            cherries = a[r][c1]+a[r][c2];
        }
       // 9 states-> 1st can be onn any 3 corresponding 2nd on any 3 so 3*3
         int max=0;
         for(int i=c1-1;i<=c1+1;i++){
             for(int j=c2-1;j<=c2+1;j++){
                 max=Math.max(max,help(a,r+1,i,j,n,m,dp));
             }
         }
        cherries+=max;
        return dp[r][c1][c2]=cherries;
    }
    
    
    /*
    
    tabulation
    
static int maximumChocolates(int n, int m, int[][] grid) {

    int dp[][][] = new int[n][m][m];

    for (int j1 = 0; j1 < m; j1++) {
      for (int j2 = 0; j2 < m; j2++) {
        if (j1 == j2)
          dp[n - 1][j1][j2] = grid[n - 1][j1];
        else
          dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
      }
    }

    //Outer Nested Loops for travering DP Array
    for (int i = n - 2; i >= 0; i--) {
      for (int j1 = 0; j1 < m; j1++) {
        for (int j2 = 0; j2 < m; j2++) {

          int maxi = Integer.MIN_VALUE;

          //Inner nested loops to try out 9 options
          for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {

              int ans;

              if (j1 == j2)
                ans = grid[i][j1];
              else
                ans = grid[i][j1] + grid[i][j2];

              if ((j1 + di < 0 || j1 + di >= m) ||
                (j2 + dj < 0 || j2 + dj >= m))

                ans += (int) Math.pow(-10, 9);
              else
                ans += dp[i + 1][j1 + di][j2 + dj];

              maxi = Math.max(ans, maxi);
            }
          }
          dp[i][j1][j2] = maxi;
        }
      }
    }

    return dp[0][0][m - 1];
}
  
    
    */
}