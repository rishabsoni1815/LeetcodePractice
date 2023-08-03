class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int dp[]=new int[m+1];
        for(int i=n;i>0;i--){
            int prev[]=new int[m+1];
            for(int j=m;j>0;j--){
                if(a[i-1][j-1]==1) {
                    prev[j]=0;
                    continue;
                }
                if(i==n && j==m){
                    prev[j]=(a[i-1][j-1]==1?(0):(1));
                }
                if(j==m||i==n){
                    if(j==m && i!=n) prev[j]=dp[j];
                    if(i==n && j!=m) prev[j]=prev[j+1];
                }else{
                    prev[j]=dp[j]+prev[j+1];
                }
            }
            dp=prev;
        }
        return dp[1];
    }
}