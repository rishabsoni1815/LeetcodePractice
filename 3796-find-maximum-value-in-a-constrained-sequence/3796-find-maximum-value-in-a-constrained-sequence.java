class Solution {
    public int findMaxVal(int n, int[][] r, int[] d) {
        int dp[]=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        int max=0;
        for(int i=0;i<r.length;i++){
            dp[r[i][0]]=r[i][1];
        }
        for(int i=1;i<n;i++){
            dp[i]=Math.min(dp[i],dp[i-1]+d[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            dp[i]=Math.min(dp[i],dp[i+1]+d[i]);
        }
        for(int i:dp) max=Math.max(max,i);
        return max;
    }
}
/*
Find the upper bound for each position
by propagating constraints from both directions.
Create a dp array initialized to infinity.
Set the initial constraints with
dp[0] = 0 and dp[idx] = maxVal for all given restrictions.

Iterate from left to right. dp[i] ≤ dp[i−1] + diff[i−1]
Iterate from right to left. dp[i] ≤ dp[i+1] + diff[i]

*/