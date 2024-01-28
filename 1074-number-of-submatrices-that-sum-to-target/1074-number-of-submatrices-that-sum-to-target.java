class Solution {
    public int numSubmatrixSumTarget(int[][] a, int t) {
        int n=a.length,m=a[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=a[i][j];
                if(i-1>=0) dp[i][j]+=dp[i-1][j];
                if(j-1>=0) dp[i][j]+=dp[i][j-1];
                if(i-1>=0 && j-1>=0) dp[i][j]-=dp[i-1][j-1];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=i;k<n;k++){
                    for(int l=j;l<m;l++){
                        int sum=dp[k][l];
                        if(j-1>=0) sum-=dp[k][j-1];
                        if(i-1>=0) sum-=dp[i-1][l];
                        if(i-1>=0 && j-1>=0) sum+=dp[i-1][j-1];
                        if(sum==t) ans++;
                    }
                }
            }
        }
        return ans;
    }
}