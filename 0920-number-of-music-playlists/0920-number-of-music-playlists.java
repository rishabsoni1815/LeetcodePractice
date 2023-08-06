class Solution {
    public int numMusicPlaylists(int n, int g, int k) {
        int mod=1000000007;
        Long dp[][]=new Long[g+1][n+1];
        return (int)help(n,0,0,g,k,mod,dp)%mod;
    }
    long help(int n,int used,int i,int g,int k,int mod,Long dp[][]){
        if(i==g) {
            if(used==n) return 1;
            return 0;
        }
        if(used>n) return 0;
        // System.out.println(i+" "+" "+used);
        if(dp[i][used]!=null) return dp[i][used];
        
        long use=(help(n,used,i+1,g,k,mod,dp)*(Math.max(0,used-k)))%mod;//placing used song at this index has this many options
        long notuse=(help(n,used+1,i+1,g,k,mod,dp)*(n-used))%mod;//place not used at this plcae
        
        return dp[i][used]=(use+notuse)%mod;
    }
}