class Solution {
    public int minFallingPathSum(int[][] a) {
        int n=a.length;
        int ans=Integer.MAX_VALUE;
        Integer dp[][]=new Integer[n][n];
        for(int i=0;i<n;i++){
            ans=Math.min(ans,help(0,i,a,n,dp));
        }
        return ans;
    }
    int help(int i,int j,int a[][],int n,Integer dp[][]){
        if(i>=n || j>=n || i<0 || j<0) return Integer.MAX_VALUE;
        if(i==n-1) return a[i][j];
        if(dp[i][j]!=null) return dp[i][j];
        int o1=help(i+1,j-1,a,n,dp);
        int o2=help(i+1,j,a,n,dp);
        int o3=help(i+1,j+1,a,n,dp);
        return dp[i][j]=a[i][j]+Math.min(o1,Math.min(o2,o3));
    }
}