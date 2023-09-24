class Solution {
    public double champagneTower(int p, int r, int c) {
        double dp[][]=new double[r+2][r+2];
        for(int i=0;i<=r;i++){
            for(int j=0;j<=i;j++){
                if(i==0){
                    dp[i][j]=p;
                    if(p>1){
                        dp[i+1][j]+=((p-1)/2.0);
                        dp[i+1][j+1]+=((p-1)/2.0);
                        dp[i][j]=1;
                    }
                }else{
                    if(dp[i][j]>1){
                        dp[i+1][j]+=((dp[i][j]-1)/2.0);
                        dp[i+1][j+1]+=((dp[i][j]-1)/2.0);
                        dp[i][j]=1;
                    }
                }
            }
        }
        return dp[r][c];
    }
}