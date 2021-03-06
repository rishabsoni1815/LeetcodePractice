class Solution {
    //https://leetcode.com/problems/cherry-pickup/discuss/329945/Very-easy-to-follow-%3A-step-by-step-recursive-backtracking-with-memoization-N4
    
    // Instead of having two paths starting from 0,0 and then other path from N,N We can have two people starting from 0,0 and Now, we know that we want collectively maximum cherries. So, we have to do the traversal of both paths at the same time and select maximum global answer. The potential problem of this approach is double counting (if we collect same cherry in 2 paths), but this can be easily avoided in code. If both are at the same cell we count cherry only once.
    
    
    
    // 4 states-> DD,DR,RD,RR 
    
    public int cherryPickup(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int dp[][][][]=new int [n][m][n][m];//(i,j of one and k,l of other)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    for(int l=0;l<m;l++){
                        dp[i][j][k][l]=-1;
                    }
                }
            }
        }
        return Math.max(0,help(a,0,0,0,0,n,m,dp));
    }
    int help(int a[][],int r1,int c1,int r2,int c2,int n,int m,int dp[][][][]){
        if(r1>=n||c1>=m||r2>=n||c2>=m||a[r1][c1]==-1||a[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==n-1&&c1==m-1){
            return a[r1][c1];
        }
        if(r2==n-1&&c2==m-1){
            return a[r2][c2];
        }
        if(dp[r1][c1][r2][c2]!=-1) return dp[r1][c1][r2][c2];
        int cherries=0;
        if(r1==r2&&c1==c2){
            cherries = a[r1][c1];
        }
        else{
            cherries = a[r1][c1]+a[r2][c2];
        }
        cherries += Math.max(Math.max(help(a,r1+1,c1,r2+1,c2,n,m,dp),help(a,r1+1,c1,r2,c2+1,n,m,dp)),Math.max(help(a,r1,c1+1,r2+1,c2,n,m,dp),help(a,r1,c1+1,r2,c2+1,n,m,dp)));
        
        return dp[r1][c1][r2][c2]=cherries;
    }
    
    
//     // O(n^3) time and space as r1 + c1 == r2 + c2 so int r2 = r1 + c1 - c2; // as only going down and right
//     public int cherryPickup(int[][] grid) {
//         int[][][] dp = new int[grid.length][grid.length][grid.length];

//         return Math.max(0, helper(grid, dp, 0, 0, 0));
//     }
//     private int helper(int[][] grid, int[][][] dp, int r1, int c1, int  c2) {
//         int r2 = r1 + c1 - c2;
//         if (r1 >= grid.length || c1 >= grid.length || r2 >= grid.length || c2 >= grid.length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
//             return Integer.MIN_VALUE; 
//         }
//         if (dp[r1][c1][c2] != 0) return dp[r1][c1][c2];
//         if (r1 == grid.length - 1 && c1 == grid.length - 1) {
//             return grid[r1][c1];
//         }
//         int result = grid[r1][c1];
//         if (r1 != r2) {
//             result += grid[r2][c2];
//         }
//         int bestNextState = Math.max(helper(grid, dp, r1 + 1, c1, c2),  // down, down 
//                                     helper(grid, dp, r1, c1 + 1, c2 + 1));  // right, right    
//         bestNextState = Math.max(bestNextState, helper(grid, dp, r1 + 1, c1, c2 + 1));   // down, right
//         bestNextState = Math.max(bestNextState, helper(grid, dp, r1, c1 + 1, c2));   // right, down

//         result += bestNextState;
//         dp[r1][c1][c2] = result; 

//         return result;
//     }
}