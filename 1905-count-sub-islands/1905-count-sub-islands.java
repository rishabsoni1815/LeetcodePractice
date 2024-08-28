class Solution {
    int dirx[]={1,-1,0,0};
    int diry[]={0,0,1,-1};
    public int countSubIslands(int[][] a, int[][] b) {
        int n=a.length,m=a[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(b[i][j]==1){
                    if(dfs(i,j,a,b,n,m)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    boolean dfs(int i,int j,int a[][],int b[][],int n,int m){
        if(a[i][j]!=b[i][j]){
            return false;
        }
        b[i][j]=0;
        boolean flag=false;
        for(int k=0;k<4;k++){
            int nx=i+dirx[k];
            int ny=j+diry[k];
            if(nx>=0 && nx<n && ny>=0 && ny<m && b[nx][ny]==1){
                if(dfs(nx,ny,a,b,n,m)==false){
                    flag|=true;
                }
            }
        }
        if(flag==true) return false;
        return true;
    }
}