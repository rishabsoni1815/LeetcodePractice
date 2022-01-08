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
}