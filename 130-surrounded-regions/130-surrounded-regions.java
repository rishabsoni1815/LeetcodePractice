class Solution {
    public void solve(char[][] b) {
        //firstly changes all the 0 on borders and connected to those to '-' ( dfs on all  border 0's c) 
        // then made all the left 0's connected components to x and then at last made all '-' to 0 again 
        int n=b.length;
        int m=b[0].length;
        for(int i=0;i<n;i++){
            if(b[i][0]=='O'){
                dfs(b,i,0,n,m);
            }
        }
        for(int i=0;i<n;i++){
            if(b[i][m-1]=='O'){
                dfs(b,i,m-1,n,m);
            }
        }
        for(int j=0;j<m;j++){
            if(b[0][j]=='O'){
                dfs(b,0,j,n,m);
            }
        }
        for(int i=0;i<m;i++){
            if(b[n-1][i]=='O'){
                dfs(b,n-1,i,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(b[i][j]=='O')
                    b[i][j]='X';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(b[i][j]=='-')
                    b[i][j]='O';
            }
        }
    }
    
    void dfs(char b[][],int i,int j,int n,int m){
        if(i<0||i>=n||j<0||j>=m||b[i][j]=='-'||b[i][j]=='X'){
            return;
        }
         b[i][j]='-';
         dfs(b,i-1,j,n,m);
         dfs(b,i+1,j,n,m);
         dfs(b,i,j-1,n,m);
         dfs(b,i,j+1,n,m);
    }
}