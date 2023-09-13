class Solution {
    public int minimumMoves(int[][] grid) {
        //sol - https://leetcode.com/submissions/detail/1048755087/                
// incorrect as -> https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/discuss/4024993/Why-Greedy-won't-Work-oror-Backtracking-oror-C%2B%2B   we dont know which zero to choose first and also which >1 to choose so that future is good basically no greedy so apply complete brute backtrack
        return help(grid);
    }
    int help(int grid[][]){
        boolean ans = true;
        for(int i = 0; i< 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j] != 1){
                    ans = false;
                    break;
                }
            }
        }
        
        if(ans){
            return 0;
        }
        
        int count = 10000;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j]!=0) continue;
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        if(grid[k][l] > 1){
                            grid[k][l] -= 1;
                            grid[i][j] = 1;
                            int d = Math.abs(i - k) + Math.abs(j - l);
                            count = Math.min(count, d + help(grid));
                            grid[k][l] += 1;
                            grid[i][j] = 0;
                        }
                    }
                }
            }
        }
        
        return count;
    }
}