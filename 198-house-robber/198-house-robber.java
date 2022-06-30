class Solution {
    public int rob(int[] a) {
        int dp[]=new int[a.length+1];
        Arrays.fill(dp,-1);
        return help(0,a,a.length,dp);
    }
    int help(int i,int a[],int n,int dp[]){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int l=a[i]+help(i+2,a,n,dp);
        int r=help(i+1,a,n,dp);
        return dp[i]=Math.max(l,r);
    }
}