class Solution {
    int y=0;
    public int countSubIslands(int[][] a, int[][] b) {
        int n=a.length;
        int m=a[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1&&b[i][j]==1){
                    dfs(i,j,a,b,n,m);
                    if(y!=5) ans++;
                    y=0;
                }
            }
        }
        return ans;
    }
   void dfs(int i,int j,int a[][],int b[][],int n,int m){
        if(i<0||i>=n||j<0||j>=m||b[i][j]==0) return;
       if(a[i][j]!=b[i][j]){
          y=5;
           return;
       }
        b[i][j]=0;
        dfs(i+1,j,a,b,n,m);
         dfs(i-1,j,a,b,n,m);
         dfs(i,j+1,a,b,n,m);
         dfs(i,j-1,a,b,n,m);
    }
}