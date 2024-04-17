class Solution {
    public int[][] floodFill(int[][] a, int x, int y, int c) {
        boolean v[][]=new boolean[a.length][a[0].length];//if dont want to use this and directly check only with a[x][y]!=p in base case then if all the nodes are of same color then this will move infinitely so without this we have to add next line
        // if (c==a[x][y]) return a;
        dfs(a,x,y,c,a.length,a[0].length,a[x][y],v);
        return a;
    }
    void dfs(int[][] a, int x, int y, int c,int n,int m,int p,boolean v[][]){
        if(x<0|x>=n||y<0||y>=m||a[x][y]!=p||v[x][y]==true) return;
        a[x][y]=c;
        v[x][y]=true;
        dfs(a,x+1,y,c,n,m,p,v);
        dfs(a,x-1,y,c,n,m,p,v);
        dfs(a,x,y+1,c,n,m,p,v);
        dfs(a,x,y-1,c,n,m,p,v);
    }
}