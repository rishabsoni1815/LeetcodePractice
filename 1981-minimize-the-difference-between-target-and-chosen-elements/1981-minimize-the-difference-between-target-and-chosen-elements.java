class Solution {
    public int minimizeTheDifference(int[][] a, int t) {
        int n=a.length;
        int m=a[0].length;
        int dp[][]=new int[n][5001];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
       return help(0,0,a,t,n,m,dp);
    }
    int help(int i,int sum,int a[][],int t,int n,int m,int dp[][]){
        if(i==n){
            return Math.abs(t-sum);
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int min=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min=Math.min(min,help(i+1,sum+a[i][j],a,t,n,m,dp));
        }
        return dp[i][sum]=min;
    }
}