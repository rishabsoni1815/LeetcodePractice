class Solution {
    int ans=-1;
    public int maximumLength(int[] a, int k) {
        int n=a.length;
        Integer dp[][]=new Integer[n+1][k+1];
        for(int i=0;i<a.length;i++) help(i,a,k,dp);
        return ans;
    }
    int help(int i,int a[],int k,Integer dp[][]){
        if(dp[i][k]!=null) return dp[i][k];
        int max=1;
        for(int j=0;j<i;j++){
            if(a[j]!=a[i] && k>0) max=Math.max(max,1+help(j,a,k-1,dp));
            if(a[j]==a[i]) max=Math.max(max,1+help(j,a,k,dp));
        }
        ans=Math.max(ans,max);
        return dp[i][k]=max;
    }
}