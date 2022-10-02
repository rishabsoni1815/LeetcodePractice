class Solution {
    int m=(int)1e9+7;
    public int numRollsToTarget(int n, int k, int t) {
        Integer dp[][]=new Integer[n+1][t+1];
        return help(0,n,k,t,dp);
    }
    int help(int s,int n,int k,int t,Integer dp[][]){
        if(n==0 && s==t) return 1;
        if(n<0||s>t) return 0;
        int ans=0;
        if(dp[n][s]!=null) return dp[n][s];
        for(int j=1;j<=k;j++){
            ans=(ans+help(s+j,n-1,k,t,dp))%m;
        }
        return dp[n][s]=ans;
    }
}