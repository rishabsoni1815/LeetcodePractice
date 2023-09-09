class Solution {
    public int combinationSum4(int[] a, int t) {
        int n=a.length;
        Integer dp[][]=new Integer[n][t+1];
        return help(a,0,n,t,dp);
    }
    int help(int a[],int i,int n,int t,Integer dp[][]){
        if(t==0) return 1;
        if(t<0 || i>=n) return 0;
        int ans=0;
        if(dp[i][t]!=null) return dp[i][t];
        for(int j=0;j<n;j++){
            ans+=help(a,j,n,t-a[j],dp);
        }
        return dp[i][t]=ans;
    }
}