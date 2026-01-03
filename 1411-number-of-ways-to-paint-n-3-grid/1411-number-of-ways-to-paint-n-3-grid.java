class Solution {
    int mod=(int)(1e9+7);
    public int numOfWays(int n) {
        Integer dp[][][][]=new Integer[n][3][3][3];
        int ans=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if((i!=j) && (j!=k)) ans=(ans%mod + help(0,i,j,k,n,dp)%mod)%mod;
                }
            }
        }
        return ans%mod;
    }
    int help(int ii,int pc1,int pc2,int pc3,int n,Integer dp[][][][]){
        if(ii>=n-1) return 1;
        int ans=0;
        if(dp[ii][pc1][pc2][pc3]!=null) return dp[ii][pc1][pc2][pc3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(valid(pc1,pc2,pc3,i,j,k)) ans=(ans%mod + help(ii+1,i,j,k,n,dp)%mod)%mod;
                }
            }
        }
        return dp[ii][pc1][pc2][pc3]=ans%mod;
    }
    boolean valid(int i,int j,int k,int a,int b,int c){
        if((i==j || i==a) || (j==k || j==b) || (a==b || b==c) || (k==c))
            return false;
        return true;
    }
}