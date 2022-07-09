class Solution {
    int color=2,size=0;
    public int largestIsland(int[][] grid) {//firstly get size of all islands then on 4 dirnts of every 0 check sum of all unique island sizes and return max
        int n=grid.length;
        int m=grid[0].length;
        HashMap<Integer,Integer>h=new HashMap<>();
        boolean v[][]=new boolean[grid.length][grid[0].length];
        boolean hasz=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0) hasz=true;
                size=0;
                if(grid[i][j]==1){
                    dfs(grid,i,j,grid.length,grid[0].length,v);
                    h.put(color,size);
                    color++;
                }
            }
        }
        if(hasz==false) return n*m;
        // System.out.println(h);
        int max=Integer.MIN_VALUE;
        int o=2;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
            int cmax=0;
            HashSet<Integer>check=new HashSet<>();//to check if neighbours belong to sma island then add only once
                if(grid[i][j]==0){
                    if(i+1<n&&j<m&&check.contains(grid[i+1][j])==false&&grid[i+1][j]>1){
                        check.add(grid[i+1][j]);
                        cmax+=h.get(grid[i+1][j]);
                    }
                     if(i-1>=0&&j<m&&check.contains(grid[i-1][j])==false&&grid[i-1][j]>1){
                        check.add(grid[i-1][j]);
                        cmax+=h.get(grid[i-1][j]);
                    }
                     if(i<n&&j+1<m&&check.contains(grid[i][j+1])==false&&grid[i][j+1]>1){
                        check.add(grid[i][j+1]);
                        cmax+=h.get(grid[i][j+1]);
                    }
                     if(i<n&&j-1>=0&&check.contains(grid[i][j-1])==false&&grid[i][j-1]>1){
                        check.add(grid[i][j-1]);
                         cmax+=h.get(grid[i][j-1]);
                    }
                }
                max=Math.max(max,cmax);
            }
        }
        return max+1;
    }
    void dfs(int[][] grid,int i,int j,int n,int m,boolean v[][]){
            if(i < 0 || j < 0 || i >= n || j >= m ||grid[i][j]==0||v[i][j]==true){
                return;
            }
            v[i][j]=true;
            size++;
            grid[i][j]=color;
            dfs(grid,i+1,j,n,m,v);
            dfs(grid,i-1,j,n,m,v);
            dfs(grid,i,j+1,n,m,v);
            dfs(grid,i,j-1,n,m,v);
    }
}