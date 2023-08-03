class Solution {
    public int rob(int[] a) {
        int n=a.length;
        Integer dp[]=new Integer [n];
        return help(0,n,a,dp);
    }
    int help(int i,int n,int a[],Integer dp[]){
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];
        return dp[i]=Math.max(a[i]+help(i+2,n,a,dp),help(i+1,n,a,dp));
    }
}