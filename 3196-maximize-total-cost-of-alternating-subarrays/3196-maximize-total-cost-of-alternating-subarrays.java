class Solution {
    public long maximumTotalCost(int[] a) {
        int n=a.length;
        if(n==1) return a[0];
        Long dp[][]=new Long[n][2];
        return help(a,n,0,1,dp);
    }
    long help(int a[],int n,int i,int positive,Long dp[][]){
        if(i>=n) return 0;
        
        if(dp[i][positive]!=null) return dp[i][positive];
        long ans=Long.MIN_VALUE;
        if(positive==1) ans=Math.max(ans,a[i]+help(a,n,i+1,0,dp));
        else {
            ans=Math.max(ans,-a[i]+help(a,n,i+1,1,dp));
        }
        ans=Math.max(ans,a[i]+Math.max(help(a,n,i+1,1,dp),help(a,n,i+1,0,dp)));
        return dp[i][positive]=ans;
    }
}