class Solution {
    public int twoCitySchedCost(int[][] c) {
        int n=c.length/2;
        int dp[][][]=new int[2*n+1][n+1][n+1];
        for(int i=0;i<=2*n;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return h(c,n,0,n,n,dp);
    }
    int h(int c[][],int n,int i,int ca,int cb,int dp[][][]){
        if(i==2*n-1){
            if(ca>0&&cb>0) return Math.min(c[i][0],c[i][1]);
            else if(ca>0){
                return c[i][0];
            }else return c[i][1];
        }
        if(dp[i][ca][cb]!=-1) return dp[i][ca][cb];
        int l=Integer.MAX_VALUE;
        if(ca>0) l=c[i][0]+h(c,n,i+1,ca-1,cb,dp);
        int r=Integer.MAX_VALUE;
        if(cb>0) r=c[i][1]+h(c,n,i+1,ca,cb-1,dp);
        return dp[i][ca][cb]=Math.min(l,r);
    }
}