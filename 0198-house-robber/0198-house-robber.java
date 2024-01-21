class Solution {
    
    //space optimised
        public int rob(int[] a) {
        int n=a.length;
        int next=0,nextToNext=0;
        int dp[]=new int[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=a[i];
            if(i+1<n) dp[i]=Math.max(dp[i],dp[i+1]);
            if(i+2<n) dp[i]=Math.max(dp[i],a[i]+dp[i+2]);
            nextToNext=next;
            next=dp[i];
        }
        return dp[0];
    }
    
    
    // public int rob(int[] a) {
    //     int n=a.length;
    //     int dp[]=new int[n];
    //     for(int i=n-1;i>=0;i--){
    //         dp[i]=a[i];
    //         if(i+1<n) dp[i]=Math.max(dp[i],dp[i+1]);
    //         if(i+2<n) dp[i]=Math.max(dp[i],a[i]+dp[i+2]);
    //     }
    //     return dp[0];
    // }
}