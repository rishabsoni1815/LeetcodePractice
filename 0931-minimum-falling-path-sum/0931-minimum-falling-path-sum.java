class Solution {
    public int minFallingPathSum(int[][] a) {
        // can space optimise as only need dp[i+1][]
        int n=a.length;
        int dp[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int pre[]=new int[n];
            for(int j=n-1;j>=0;j--){
                if(i==n-1){
                    pre[j]=a[i][j];
                    continue;
                }
                pre[j]=Integer.MAX_VALUE;
                if(i+1<n) pre[j]=Math.min(pre[j],a[i][j]+dp[j]);
                if(i+1<n&&j+1<n) pre[j]=Math.min(pre[j],a[i][j]+dp[j+1]);
                if(i+1<n&&j-1>=0) pre[j]=Math.min(pre[j],a[i][j]+dp[j-1]);
            }
            dp=pre;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[i]);
        }
        return min;
    }
    /*
    
     public int minFallingPathSum(int[][] a) {
        int n=a.length;
        int dp[][]=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==n-1){
                    dp[i][j]=a[i][j];
                    continue;
                }
                dp[i][j]=Integer.MAX_VALUE;
                if(i+1<n) dp[i][j]=Math.min(dp[i][j],a[i][j]+dp[i+1][j]);
                if(i+1<n&&j+1<n) dp[i][j]=Math.min(dp[i][j],a[i][j]+dp[i+1][j+1]);
                if(i+1<n&&j-1>=0) dp[i][j]=Math.min(dp[i][j],a[i][j]+dp[i+1][j-1]);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[0][i]);
        }
        return min;
    }
    
    */
}