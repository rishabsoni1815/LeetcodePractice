class Solution {
    public int rob(int[] a) {
        int n=a.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
       return find(0,n,dp,a);
    }
    int find(int i,int n,int dp[],int a[]){
        if(i>n) return 0;
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=Math.max(a[i]+find(i+2,n,dp,a),find(i+1,n,dp,a));
    }
}