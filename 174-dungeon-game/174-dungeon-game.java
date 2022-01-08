class Solution {
    public int calculateMinimumHP(int[][] a) {
        int n=a.length;int m=a[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return help(0,0,a,n,m,dp);
    }
    public int help(int i,int j,int a[][],int n,int m,int dp[][]){
        if(i==n-1&&j==m-1){
            return dp[i][j] = Math.max(1,-1*a[i][j] +1);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int l=Integer.MAX_VALUE,r=Integer.MAX_VALUE;
        if(i+1<n) l=help(i+1,j,a,n,m,dp);
        if(j+1<m) r=help(i,j+1,a,n,m,dp);
        if(l==Integer.MAX_VALUE){
            return dp[i][j] = Math.max(1,r-a[i][j]);
        }
        if(r==Integer.MAX_VALUE){
            return dp[i][j] = Math.max(1,l-a[i][j]);
        }
        return dp[i][j] = Math.max(1,Math.min(l-a[i][j],r-a[i][j]));
    }
}