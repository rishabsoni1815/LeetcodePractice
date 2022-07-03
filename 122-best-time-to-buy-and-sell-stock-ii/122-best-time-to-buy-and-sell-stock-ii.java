class Solution {
    public int maxProfit(int[] a) {
        int n=a.length;
        Integer dp[]=new Integer[n];
        return help(n-1,a,dp);
    }
    int help(int i,int a[],Integer dp[]){
        if(i<=0) return 0;
        int max=0;
        if(dp[i]!=null) return dp[i];
        for(int j=0;j<=i;j++){
            max=Math.max(max,a[i]-a[j]+help(j-1,a,dp));
        }
        return dp[i]=max;
    }
}