class Solution {
    
    public int coinChange(int[] a, int t) {
        int n=a.length;
        int dp[]=new int[t+1];
        for(int i=0;i<=t;i++) dp[i]= Integer.MAX_VALUE-1;
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int prev[]=new int[t+1];
            for(int j=1;j<=t;j++){
                int nt=dp[j];
                int ta=Integer.MAX_VALUE-1;
                if(j-a[i-1]>=0) ta=1+prev[j-a[i-1]];
                prev[j]=Math.min(ta,nt);
            }
            dp=prev;
        }
        int ans=dp[t];
        return ans==Integer.MAX_VALUE-1?-1:ans;
    }
    //only i-1 required so
    // public int coinChange(int[] a, int t) {
    //      int n=a.length;
    //     int dp[][]=new int[n+1][t+1];
    //     for(int i=0;i<=t;i++) dp[0][i]=Integer.MAX_VALUE-1;
    //     dp[0][0]=0;
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=t;j++){
    //             int nt=dp[i-1][j];
    //             int ta=Integer.MAX_VALUE-1;
    //             if(j-a[i-1]>=0) ta=1+dp[i][j-a[i-1]];
    //             dp[i][j]=Math.min(ta,nt);
    //         }
    //     }
    //     int ans=dp[n][t];
    //     return ans==Integer.MAX_VALUE-1?-1:ans;
    // }
    
   static int help(int i,int t,int a[],Integer dp[][]){
        if(t==0) return 0;
        if(i<0 || t<0) return Integer.MAX_VALUE-1;
       if(dp[i][t]!=null) return dp[i][t];
        return dp[i][t]=Math.min(1+help(i,t-a[i],a,dp),help(i-1,t,a,dp));
    }
}