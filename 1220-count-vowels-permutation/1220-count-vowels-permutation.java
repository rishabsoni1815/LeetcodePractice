class Solution {
    public int countVowelPermutation(int n) {
        int ans=0,mod=(int)(1e9+7);
        Integer dp[][]=new Integer[n+1][5];
        for(int i=0;i<=4;i++){
            ans=(ans+help(n,i,mod,dp)%mod)%mod;
        }
        return ans;
    }
    int help(int n,int c,int mod,Integer dp[][]){
        if(n-1==0) return 1;
        if(dp[n][c]!=null) return dp[n][c];
        int ans=0;
        if(c==0){
            ans=(ans+help(n-1,1,mod,dp)%mod)%mod;
            
        }else if(c==1){
            ans=(ans+help(n-1,0,mod,dp)%mod)%mod;
            ans=(ans+help(n-1,2,mod,dp)%mod)%mod;
            
        }else if(c==2){
            ans=(ans+help(n-1,0,mod,dp)%mod)%mod;
            ans=(ans+help(n-1,1,mod,dp)%mod)%mod;
            ans=(ans+help(n-1,3,mod,dp)%mod)%mod;
            ans=(ans+help(n-1,4,mod,dp)%mod)%mod;
            
        }else if(c==3){
            ans=(ans+help(n-1,2,mod,dp)%mod)%mod;
            ans=(ans+help(n-1,4,mod,dp)%mod)%mod;
            
        }else{
            ans=(ans+help(n-1,0,mod,dp)%mod)%mod;
            
        }
        return dp[n][c]=ans;
    }
}