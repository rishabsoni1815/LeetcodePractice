class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
       return find(0,n,dp);
    }
    int find(int i,int n,int dp[]){
        if(i>n) return 0;
        if(i==n) return 1;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=find(i+1,n,dp)+find(i+2,n,dp);
    }
}