class Solution {
    
    public int findLength(int[] a, int[] b) {
        int ans=0;//considering i,j as end points of our longest repeat subarray
        int n=a.length,m=b.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
    
    //memoisation tle-> o(n*n*m)
    // public int findLength(int[] a, int[] b) {
    //     int n=a.length,m=b.length;
    //     Integer dp[][][]=new Integer[n][m][n];
    //     return help(n-1,m-1,a,b,0,dp);
    // }
    // int help(int i,int j,int a[],int b[],int c,Integer dp[][][]){
    //     if(i<0 || j<0) return c;
    //     if(dp[i][j][c]!=null) return dp[i][j][c];
    //     int x=c;
    //     if(a[i]==b[j]) x=help(i-1,j-1,a,b,c+1,dp);
    //     return dp[i][j][c]=Math.max(x,Math.max(help(i-1,j,a,b,0,dp),help(i,j-1,a,b,0,dp)));
    // }
}