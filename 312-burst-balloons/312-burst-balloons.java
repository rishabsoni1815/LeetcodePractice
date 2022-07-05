class Solution {
    public int maxCoins(int[] b) {
        int n=b.length;
        n+=2;
        int a[]=new int[n];
        a[0]=1;
        a[n-1]=1;
        Integer dp[][]=new Integer[n][n];
        for(int i=0;i<b.length;i++) a[i+1]=b[i];
        return help(1,n-1,a,dp);
    }
    int help(int i,int j,int a[],Integer dp[][]){
        if(i==j) return 0;
        int max=0;
        if(dp[i][j]!=null) return dp[i][j];
        for(int k=i;k<j;k++){
            max=Math.max(max,a[i-1]*a[k]*a[j]+help(i,k,a,dp)+help(k+1,j,a,dp));
        }
        return dp[i][j]=max;
    }
}