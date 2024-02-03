class Solution {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int n=a.length;
        Integer dp[]=new Integer[n];
        return help(0,a,k,n,dp);
    }
    int help(int i,int a[],int k,int n,Integer dp[]){
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];
        int max=a[i],ans=0;
        for(int j=i;j<Math.min(n,(k+i));j++){
            max=Math.max(max,a[j]);
            ans=Math.max(ans,max*(j-i+1)+help(j+1,a,k,n,dp));
        }
        return dp[i]=ans;
    }
}