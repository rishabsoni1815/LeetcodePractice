class Solution {
    public int maxCoins(int[] b) {
        int n=b.length;
        n+=2;
        int a[]=new int[n];
        a[0]=1;
        a[n-1]=1;
        for(int i=0;i<b.length;i++) a[i+1]=b[i];
        
        // Integer dp[][]=new Integer[n][n];//memoisation
        // return help(1,n-1,a,dp);
        
        int dp[][]=new int[n][n];
        for(int i=n-1;i>0;i--){//need k+1 dp so doing from n-1  to 0
            for(int j=i+1;j<n;j++){
                int max=0;
                for(int k=i;k<j;k++){
                    max=Math.max(max,a[i-1]*a[k]*a[j]+dp[i][k]+dp[k+1][j]);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n-1];
    }
    int help(int i,int j,int a[],Integer dp[][]){
        if(i==j) return 0;
        int max=0;
        if(dp[i][j]!=null) return dp[i][j];
        for(int k=i;k<=j;k++){
            max=Math.max(max,a[i-1]*a[k]*a[j+1]+help(i,k,a,dp)+help(k+1,j,a,dp));
        }
        return dp[i][j]=max;
    }
}