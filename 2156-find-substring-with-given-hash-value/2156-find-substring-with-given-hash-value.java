class Solution {
    public String subStrHash(String s, int p, int mod, int k, int v) {
        // cant move hash (window) by dividing by p as p is not primt in modular arithmetic we can only divide by p if p is prime as division in modular inverse only i.e x/p is x*modular inverse of p modular inverse exists only if no. is prime so think of miultiplying and moving window from back 
        int n=s.length();
        long hash=0;
        int ind=n;
        long pow=1;
        for(int i=n-1;i>=0;i--){
            hash = ((hash*p)%mod + (s.charAt(i)-'a'+1)*1)%mod;
            if(i+k>=n){
                pow = (pow*p)%mod;
            }else{
                hash = (hash - ((s.charAt(i+k)-'a'+1)*pow)%mod +mod)%mod;
            }
            if(hash==v){
                ind=i;
            }
        }
        return s.substring(ind,ind+k);
    }
}