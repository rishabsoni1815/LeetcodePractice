class Solution {
    public int countPaths(int[][] a) {
         int n=a.length;int mod=(int)(1e9+7);
        int m=a[0].length;
        int ans=0;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=(ans%mod+(1+help(i,j,a,n,m,dp,mod)%mod)%mod)%mod;
            }
        }
        return ans%mod;
    }
    int help(int i,int j,int a[][],int n,int m,int dp[][],int mod){
        if(dp[i][j]!=0) return dp[i][j];
        int res=0;
        int dirx[]={-1,1,0,0};
        int diry[]={0,0,1,-1};
        for(int ii=0;ii<4;ii++){
            int x=i+dirx[ii];
            int y=j+diry[ii];
            if(x>=0 && x<n && y<m && y>=0 && a[x][y]>a[i][j]){
                res=(res%mod+(1+help(x,y,a,n,m,dp,mod))%mod)%mod;
            }
        }
        return dp[i][j]=res%mod;
    }
}