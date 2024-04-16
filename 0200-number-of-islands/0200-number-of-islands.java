class Solution {
    public int numIslands(char[][] a) {
        int n=a.length,m=a[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='1'){
                    dfs(i,j,a);
                    ans++;
                }
            }
        }
        return ans;
    }
    void dfs(int i,int j,char a[][]){
        if(i<0||i>=a.length||j<0||j>=a[0].length||a[i][j]=='0') return;
        a[i][j]='0';
        dfs(i+1,j,a);
        dfs(i-1,j,a);
        dfs(i,j-1,a);
        dfs(i,j+1,a);
    }
}