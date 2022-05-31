class Solution {
    public boolean canJump(int[] a) {
        //as if no 0 in array then always possible by taking 1 step all times so we have to avoid 0 by taking maximum where we can go by below method
        //greedy is whereever max we can go there let's say first index say we can go till 5th then when going through 1 to 5 if we get a better right going pos. (a[i]+i > cur_reach) then update cur_reach and let's go there
         int n=a.length;
         int cur_reach=a[0];
        for(int i=0;i<n;i++){
            if(cur_reach<i) return false;
            cur_reach=Math.max(cur_reach,i+a[i]);
        }
        return true;
    }
    
    /*
    dp->o(n^2)
    public boolean canJump(int[] a) {
         int n=a.length;
        long dp[]=new long[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=i+1;j<n&&j<=(i+a[i]);j++){
                dp[i]=Math.min(dp[i],1+dp[j]);
            }
        }
        return (int)dp[0]!=Integer.MAX_VALUE;
    }
    
    */
}