class Solution {
    int x[], y[];
    Solution()
    {
        x = new int[]{0, 1, 0, -1};
        y = new int[]{1, 0, -1, 0};
    }
    public boolean DFS(char[][] grid, boolean [][] visited, int last_r, int last_c, int curr_r, int curr_c, char c, int r, int cols)
    {
        visited[curr_r][curr_c] = true;
        
        
        for (int i = 0; i < 4; i++)
        {
            int next_X = curr_r + x[i];
            int next_Y = curr_c + y[i];
            if (next_X >=0 && next_X < r && next_Y >=0 && next_Y < cols && grid[next_X][next_Y] == c)
            {
                if(visited[next_X][next_Y]==false){
                    if(DFS(grid,visited,curr_r,curr_c,next_X,next_Y,c,r,cols)) return true;
                }else{
                    if(next_X!=last_r && next_Y!=last_c) return true;
                }
                
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean visited[][] = new boolean[r][c];
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (visited[i][j] == false)
                {
                    if(DFS(grid, visited, -1, -1, i, j, grid[i][j], r, c))
                        return true;
                }
            }
        }
        return false;
    }
}