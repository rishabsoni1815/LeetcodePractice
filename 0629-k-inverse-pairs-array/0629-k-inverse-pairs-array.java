class Solution {
    //how subproblems are made as placeing 1 at first left are 2,,3,4 but they can be thought of as 1,2,3 only --> https://www.youtube.com/watch?v=T6sqckjfjNw
    public int kInversePairs(int n, int k) {
        Integer dp[][]=new Integer[n+1][k+1];
        return help(n,k,1000000007,dp);
    }
    int help(int n,int k,int mod,Integer dp[][]){
        if(n==1 && k==0) return 1;
        if(n==1 && k!=0) return 0;
        int ans=0;
        if(dp[n][k]!=null) return dp[n][k];
        for(int i=0;i<=Math.min(k,n-1);i++){
            ans=(ans+(help(n-1,k-i,mod,dp)))%mod;
        }
        return dp[n][k]=ans%mod;
    }
}