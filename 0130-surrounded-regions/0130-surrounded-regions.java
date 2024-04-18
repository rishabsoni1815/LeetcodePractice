class Solution {
    public void solve(char[][] a) {
        int n=a.length;
        int m=a[0].length;
        //first dfs and mark all islands on edges and after that replate left islands with X and again turn back edges ones to 0
        for(int i=0;i<n;i++){
          if(a[i][0]=='O'){
              dfs(i,0,a);
          }   
        }
        for(int i=0;i<n;i++){
          if(a[i][m-1]=='O'){
              dfs(i,m-1,a);
          }   
        }
        for(int j=0;j<m;j++){
          if(a[0][j]=='O'){
              dfs(0,j,a);
          }   
        }
        for(int j=0;j<m;j++){
          if(a[n-1][j]=='O'){
              dfs(n-1,j,a);
          }   
        }
        //mark other than edges ones to X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='O'){
                    a[i][j]='X';
                }
            }
        }
        //marking edges ones back to O
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='1'){
                    a[i][j]='O';
                }
            }
        }
    }
    void dfs(int i,int j,char a[][]){
        if(i<0||i>=a.length||j<0||j>=a[0].length||a[i][j]!='O') return ;
        a[i][j]='1';//randomly assigning to change in last
        dfs(i+1,j,a);
        dfs(i-1,j,a);
        dfs(i,j+1,a);
        dfs(i,j-1,a);
    }
}