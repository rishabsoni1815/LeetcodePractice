class Solution {
    public int longestIncreasingPath(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int ans=1;
        Integer dp[][]=new Integer[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean v[][]=new boolean[n][m];
                help(i,j,v,a,n,m,dp);
                ans=Math.max(ans,1+dp[i][j]);
            }
        }
        return ans;
    }
    int help(int i,int j,boolean v[][],int a[][],int n,int m,Integer dp[][]){
        if(i<0||i>=n||j<0||j>=m||v[i][j]==true){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        v[i][j]=true;
        int max=0;
        int dirx[]={-1,1,0,0};
        int diry[]={0,0,1,-1};
        for(int ii=0;ii<4;ii++){
            int x=i+dirx[ii];
            int y=j+diry[ii];
            if(x>=0 && x<n && y<m && y>=0 && v[x][y]==false && a[x][y]>a[i][j]){
                max=Math.max(max,1+help(x,y,v,a,n,m,dp));
            }
        }
        v[i][j]=false;
        return dp[i][j]=max;
    }
}