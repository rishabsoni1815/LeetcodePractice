class Solution {
    public int countHomogenous(String s) {
        int n=s.length(),ans=0,mod=(int)1e9+7;
        long c=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                c++;
            }else{
                long y=(c%mod*(c+1)%mod)%mod;
                y=y>>1;
                ans=(int)(ans+y)%mod;
                c=1;
            }
        }
        long y=(c%mod*(c+1)%mod)%mod;
        y=y>>1;
        ans=(int)(ans+y)%mod;
        return ans%mod;
    }
}