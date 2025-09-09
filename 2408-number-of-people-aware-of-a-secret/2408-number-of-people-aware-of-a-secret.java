class Solution {
    int mod=(int)(1e9+7);
    public int peopleAwareOfSecret(int n, int d, int f) {
        Integer dp[]=new Integer[n+1];
        //dp[day] is the number of persons from now i.e. "day" who will remember the secret till nth day
        return help(1,n,d,f,dp);
    }
    int help(int day,int n,int d,int f,Integer dp[]){
        if(dp[day]!=null) return dp[day];
        int ans=0;
        if(day+f>n) ans++;//he knows secret at this day but if day+f<=n then till nth day he will forget secret so only inc if day+f<n
        for(int i=day+d;i<Math.min(day+f,n+1);i++){
            ans=(ans%mod+help(i,n,d,f,dp)%mod)%mod;
        }
        return dp[day]=ans%mod;
    }
}