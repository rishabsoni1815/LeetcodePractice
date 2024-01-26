class Solution {
    public int findPaths(int n, int m, int k, int i, int j) {
        Long dp[][][]=new Long[n][m][k+1];
        return (int)help(n,m,k,i,j,1000000007,dp);
    }
    long help(int n,int m,int k,int i,int j,int mod,Long dp[][][]){
        if(k<0) return 0;
        if(i>=n || i<0 ||j>=m||j<0) return 1;
        if(dp[i][j][k]!=null) return dp[i][j][k];
        return dp[i][j][k]=(help(n,m,k-1,i+1,j,mod,dp)%mod + help(n,m,k-1,i,j+1,mod,dp)%mod + help(n,m,k-1,i-1,j,mod,dp)%mod + help(n,m,k-1,i,j-1,mod,dp)%mod)%mod;
    }
}