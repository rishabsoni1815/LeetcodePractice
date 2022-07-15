class Solution {
    public int longestIncreasingPath(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int ans=1;
        Integer dp[][]=new Integer[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                help(i,j,a,n,m,dp);//no need of visited and doing backtracking by first making it true and then false again as don't need backtracking here
                ans=Math.max(ans,1+dp[i][j]);
            }
        }
        return ans;
    }
    int help(int i,int j,int a[][],int n,int m,Integer dp[][]){
        if(dp[i][j]!=null) return dp[i][j];
        int max=0;
        int dirx[]={-1,1,0,0};
        int diry[]={0,0,1,-1};
        for(int ii=0;ii<4;ii++){
            int x=i+dirx[ii];
            int y=j+diry[ii];
            if(x>=0 && x<n && y<m && y>=0 && a[x][y]>a[i][j]){
                max=Math.max(max,1+help(x,y,a,n,m,dp));
            }
        }
        return dp[i][j]=max;
    }
}