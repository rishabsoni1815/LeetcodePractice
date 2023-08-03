class Solution {
    public int rob(int[] a) {
        int n=a.length;
        // Integer dp[]=new Integer [n];
        // return help(0,n,a,dp);
        int dp[]=new int[n];
        dp[0]=a[0];
        for(int i=1;i<n;i++){
            int r=a[i];
            dp[i]=Math.max(r,dp[i-1]);
            if(i-2>=0) dp[i]=Math.max(dp[i],r+dp[i-2]);
        }
        return dp[n-1];
    }
    int help(int i,int n,int a[],Integer dp[]){
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];
        return dp[i]=Math.max(a[i]+help(i+2,n,a,dp),help(i+1,n,a,dp));
    }
}