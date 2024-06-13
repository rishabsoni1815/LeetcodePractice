class Solution {
    public int maxTotalReward(int[] a) {
        int n=a.length;
        if(n==1) return a[0];
        Arrays.sort(a);
        Integer dp[][]=new Integer[n+1][10004];
        return help(0,a,n,0,dp);
    }
    int help(int i,int a[],int n,int r,Integer dp[][]){
        if(i==n) return r;
        int ans=a[i];
        if(dp[i][r]!=null) return dp[i][r];
        if(a[i]>r){
            ans=Math.max(ans,help(i+1,a,n,r+a[i],dp));
        }
        ans=Math.max(ans,help(i+1,a,n,r,dp));
        return dp[i][r]=ans;
    }
}