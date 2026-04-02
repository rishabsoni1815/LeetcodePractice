class Solution {

    public int maximumAmount(int[][] a) {

        int n = a.length;
        int m = a[0].length;

        Integer dp[][][] = new Integer[n][m][3];

        return help(0, 0, a, n, m, 2, dp);
    }

    int help(int i, int j,
            int a[][],
            int n, int m,
            int c,
            Integer dp[][][]) {

        if (i >= n || j >= m)
            return Integer.MIN_VALUE;

        // destination
        if (i == n - 1 && j == m - 1) {
            return (a[i][j] < 0 && c > 0)
                    ? 0
                    : a[i][j];
        }

        if (dp[i][j][c] != null)
            return dp[i][j][c];

        int ans = Integer.MIN_VALUE;

        int down = help(i + 1, j, a, n, m, c, dp);
        int right = help(i, j + 1, a, n, m, c, dp);

        if (a[i][j] >= 0) {

            if (down != Integer.MIN_VALUE)
                ans = Math.max(ans, a[i][j] + down);

            if (right != Integer.MIN_VALUE)
                ans = Math.max(ans, a[i][j] + right);

        } else {

            // skip negative
            if (c > 0) {

                ans = Math.max(ans,
                        help(i + 1, j, a, n, m, c - 1, dp));

                ans = Math.max(ans,
                        help(i, j + 1, a, n, m, c - 1, dp));
            }

            // take negative
            if (down != Integer.MIN_VALUE)
                ans = Math.max(ans, a[i][j] + down);

            if (right != Integer.MIN_VALUE)
                ans = Math.max(ans, a[i][j] + right);
        }

        return dp[i][j][c] = ans;
    }
}