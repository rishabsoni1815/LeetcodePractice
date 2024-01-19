class Solution {
    public int minFallingPathSum(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        Integer dp[][]=new Integer[n][m];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min=Math.min(min,help(0,i,a,dp));
        }
        return min;
    }
    int help(int i,int j,int a[][],Integer dp[][]){
        if(i==a.length-1) return a[i][j];
        if(dp[i][j]!=null) return dp[i][j];
        int min=Integer.MAX_VALUE;
        if(i+1<a.length) min=Math.min(min,help(i+1,j,a,dp));
        if(i+1<a.length && j-1>=0) min=Math.min(min,help(i+1,j-1,a,dp));
        if(i+1<a.length && j+1<(a[0].length)) min=Math.min(min,help(i+1,j+1,a,dp));
        return dp[i][j]=min+a[i][j];
    }
}