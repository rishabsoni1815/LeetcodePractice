class Solution {
    public boolean PredictTheWinner(int[] a) {
        int n=a.length;
        int s=0;
        for(int u:a) s+=u;
        Integer dp[][]=new Integer[n][n];
        int y=help(0,n-1,a,0,dp);
        if(2*y>=s) return true;
        return false;
        
    }
    int help(int i,int j,int a[],int b,Integer dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int x=a[i]+Math.min(help(i+2,j,a,1-b,dp),help(i+1,j-1,a,1-b,dp));
        int y=a[j]+Math.min(help(i,j-2,a,1-b,dp),help(i+1,j-1,a,1-b,dp));
        return dp[i][j]=Math.max(x,y);
    }
}