class Solution {
    public int monkeyMove(int n) {
        int mod=(int)(1e9+7);
        return (int)(help(n,mod)-2+mod)%mod;
    }
    long help(int n,int mod){
        if(n==0) return 1;
        if(n%2==0){
            long x= help(n/2,mod)%mod;
            return (x*x)%mod;
        }else{
            long x= help(n/2,mod)%mod;
            return (2*(x*x)%mod)%mod;
        }
    }
}