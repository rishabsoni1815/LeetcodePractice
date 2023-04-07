class Solution {
    public int numEnclaves(int[][] a) {
        // made all connected components of all 1's at boundary to zero then count all left off 1
        int n=a.length;
        int m=a[0].length;
        for(int i=0;i<n;i++){
            if(a[i][0]==1) dfs(a,i,0,n,m);
        }
        for(int i=0;i<n;i++){
            if(a[i][m-1]==1) dfs(a,i,m-1,n,m);
        }
        for(int i=0;i<m;i++){
            if(a[0][i]==1) dfs(a,0,i,n,m);
        }
        for(int i=0;i<m;i++){
            if(a[n-1][i]==1) dfs(a,n-1,i,n,m);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1) ans++;
            }
        }
        return ans;
    }
        void dfs(int b[][],int i,int j,int n,int m){
        if(i<0||i>=n||j<0||j>=m||b[i][j]==0){
            return;
        }
         b[i][j]=0;
         dfs(b,i-1,j,n,m);
         dfs(b,i+1,j,n,m);
         dfs(b,i,j-1,n,m);
         dfs(b,i,j+1,n,m);
    }
}