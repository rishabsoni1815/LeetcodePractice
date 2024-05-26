class Solution {
    int mod=(int)(1e9 +7);
    public int checkRecord(int n) {
        Integer dp[][][]=new Integer[n+1][3][2];
        return help(n,2,1,dp);
    }
    int help(int n,int l,int a,Integer dp[][][]){
        
        if(n==0) {
            if(l<0 || a<0) return 0;
            return 1;
        }
        
        if(dp[n][l][a]!=null) return dp[n][l][a];
        int ans=0;
       
        if(l>0){
            ans=(ans%mod + help(n-1,l-1,a,dp)%mod) % mod;//placing l so l-1 , a
        }
        if(a>0){
            ans=(ans%mod + help(n-1,2,a-1,dp)%mod) % mod;//placing a so 2(l set to 2 again),a-1
        }
        
        ans=(ans%mod + help(n-1,2,a,dp)%mod) % mod;//placing p so 2(l set to 2 agin),a (a cant be reborn)

        return dp[n][l][a]=ans%mod;
    }
}