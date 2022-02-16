class Solution {
    public int minFallingPathSum(int[][] a) {
        // can space optimise as only need dp[i+1][]
        int n=a.length;
        int pre[]=new int[n];
        for(int i=0;i<n;i++) pre[i]=a[n-1][i];
        for(int i=n-2;i>=0;i--){
            int cur[]=new int[n];
            for(int j=n-1;j>=0;j--){
                cur[j]=a[i][j]+pre[j];
                if(j+1<n) cur[j]=Math.min(cur[j],a[i][j]+pre[j+1]);
                if(j-1>=0) cur[j]=Math.min(cur[j],a[i][j]+pre[j-1]);
            }
            System.out.println();
            pre=cur;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,pre[i]);
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