class Solution {
    int mod=(int) 1e9+7;
    public int countOrders(int n) {
        long dp[][]=new long[n+1][n+1];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
       return (int)help(n,n,dp)%mod;
    }
    long help(int up,int ud,long dp[][]){
        if(up==0 && ud==0) return 1;
        if(up<0 || ud<0) return 0;
        if(dp[up][ud]!=-1) return dp[up][ud];
        long pick=(up%mod*help(up-1,ud,dp)%mod)%mod;
        
        long deliver=((ud-up)%mod*help(up,ud-1,dp)%mod)%mod;//undelivered - unpicked => (orders which are picked but not delivered)
        return dp[up][ud]=(pick%mod+deliver%mod)%mod;
    }
}