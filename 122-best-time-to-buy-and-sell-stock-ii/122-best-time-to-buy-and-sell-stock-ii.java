class Solution {
    public int maxProfit(int[] a) {
        int n=a.length;
        // take whenever we have profit (a[i]-a[i-1]>0)
        int ans=0;
        for(int i=1;i<n;i++){
            ans+=Math.max(0,a[i]-a[i-1]);
        }
        return ans;
    }
    //dp
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