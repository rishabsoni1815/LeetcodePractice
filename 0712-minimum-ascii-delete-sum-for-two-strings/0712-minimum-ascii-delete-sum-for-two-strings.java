class Solution {
    public int minimumDeleteSum(String a, String b) {
        // Integer dp[][] = new Integer[a.length()][b.length()];
        // return help(a, b, a.length() - 1, b.length() - 1, dp);
        int n = a.length(), m = b.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                    continue;
                } else if (i == 0) {
                    dp[i][j] = b.charAt(j - 1) + dp[i][j - 1];
                    continue;
                } else if (j == 0) {
                    dp[i][j] = a.charAt(i - 1) + dp[i - 1][j];
                    continue;
                }
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int o1 = a.charAt(i - 1) + dp[i - 1][j];
                    int o2 = b.charAt(j - 1) + dp[i][j - 1];
                    int o3 = a.charAt(i - 1) + b.charAt(j - 1) + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(o1, Math.min(o2, o3));
                }
            }
        }
        return dp[n][m];
    }

    // int help(String a, String b, int i, int j, Integer dp[][]) {
    //     if (i < 0 || j < 0) {
    //         if (i < 0 && j < 0)
    //             return 0;
    //         else {
    //             int c = 0;
    //             if (i >= 0) {
    //                 for (int k = i; k >= 0; k--)
    //                     c += a.charAt(k);
    //             } else {
    //                 for (int k = j; k >= 0; k--)
    //                     c += b.charAt(k);
    //             }
    //             return c;
    //         }
    //     }
    //     if (dp[i][j] != null)
    //         return dp[i][j];
    //     if (a.charAt(i) == b.charAt(j))
    //         return dp[i][j] = help(a, b, i - 1, j - 1, dp);
    //     int o1 = a.charAt(i) + help(a, b, i - 1, j, dp);
    //     int o2 = b.charAt(j) + help(a, b, i, j - 1, dp);
    //     int o3 = a.charAt(i) + b.charAt(j) + help(a, b, i - 1, j - 1, dp);
    //     return dp[i][j] = Math.min(o3, Math.min(o1, o2));
    // }
}