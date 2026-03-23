class Solution {

    int mod = (int)(1e9 + 7);

    public int maxProductPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Long[][] max = new Long[m][n];
        Long[][] min = new Long[m][n];

        long[] res = dfs(grid, 0, 0, max, min);

        if (res[0] < 0) return -1;

        return (int)(res[0] % mod);
    }

    long[] dfs(int[][] grid, int i, int j,
               Long[][] max,
               Long[][] min) {

        int m = grid.length;
        int n = grid[0].length;

        // out of bounds
        if (i >= m || j >= n)
            return new long[]{
                Long.MIN_VALUE,
                Long.MAX_VALUE
            };

        // destination
        if (i == m - 1 && j == n - 1)
            return new long[]{
                grid[i][j],
                grid[i][j]
            };

        // memo
        if (max[i][j] != null)
            return new long[]{
                max[i][j],
                min[i][j]
            };

        long[] down = dfs(grid, i + 1, j, max, min);
        long[] right = dfs(grid, i, j + 1, max, min);

        long val = grid[i][j];

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        // check DOWN
        if (down[0] != Long.MIN_VALUE) {
            long p = val * down[0];
            maxVal = Math.max(maxVal, p);
            minVal = Math.min(minVal, p);
        }

        if (down[1] != Long.MAX_VALUE) {
            long p = val * down[1];
            maxVal = Math.max(maxVal, p);
            minVal = Math.min(minVal, p);
        }

        // check RIGHT
        if (right[0] != Long.MIN_VALUE) {
            long p = val * right[0];
            maxVal = Math.max(maxVal, p);
            minVal = Math.min(minVal, p);
        }

        if (right[1] != Long.MAX_VALUE) {
            long p = val * right[1];
            maxVal = Math.max(maxVal, p);
            minVal = Math.min(minVal, p);
        }

        max[i][j] = maxVal;
        min[i][j] = minVal;

        return new long[]{maxVal, minVal};
    }
}