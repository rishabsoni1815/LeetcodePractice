class Solution {
    public int numTilings(int n) {
        
        /*
        
        https://leetcode.com/problems/domino-and-tromino-tiling/discuss/116581/Detail-and-explanation-of-O(n)-solution-why-dpn2*dn-1%2Bdpn-3
        
        */
        int mod=(1000000007);
        int a[]=new int[n+1];
        a[0]=1;
        if(n>=1)a[1]=1;
        if(n>=2) a[2]=2;
        if(n>=3) a[3]=5;
        for(int i=4;i<=n;i++){
            a[i]=((2*a[i-1]%mod)+(a[i-3]%mod))%mod;
           // a[i]%=mod;
        }
        return a[n];
    }
}