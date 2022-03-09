class Solution {
    public boolean canJump(int[] a) {
        //greedy is whereever max we can go there let's say first index say we can go till 5th then when going through 1 to 5 if we get a better right going pos. (a[i]+i > cur_reach) then update cur_reqach and let's go there
         int n=a.length;
         int cur_reach=0;
        for(int i=0;i<=cur_reach;i++){
            if(i==n-1) return true;
            cur_reach=Math.max(cur_reach,i+a[i]);
            // or we can do like this
            //if(i+a[i] > cur_reach) cur_reach=i+a[i];
        }
        return false;
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