class Solution {
    public int maxPathScore(int[][] a, int k) {
        Integer dp[][][]=new Integer[a.length][a[0].length][k+1];
        int ans = help(0, 0, a.length, a[0].length, a, k,dp);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    int help(int i, int j, int n, int m, int a[][], int k,Integer dp[][][]) {
        if (i < 0 || i >= n || j < 0 || j >= m || k < 0)
            return Integer.MIN_VALUE;
        if (i == n - 1 && j == m - 1){
            if(a[i][j]==0) return a[i][j];
            else{
                if(k>0) return a[i][j];
                return Integer.MIN_VALUE;
            }
        }
        if(dp[i][j][k]!=null) return dp[i][j][k];
        int ans = Integer.MIN_VALUE;
        int nk = k;
        if (a[i][j] == 0) {
            int cur = help(i + 1, j, n, m, a, nk,dp);
            if (cur != Integer.MIN_VALUE)
                ans = Math.max(ans, cur);
            cur = help(i, j + 1, n, m, a, nk,dp);
            if (cur != Integer.MIN_VALUE)
                ans = Math.max(ans, cur);
        } else if (a[i][j] == 1) {
            nk = k - 1;
            int cur = help(i + 1, j, n, m, a, nk,dp);
            if (cur != Integer.MIN_VALUE)
                ans = Math.max(ans, 1 + cur);
            cur = help(i, j + 1, n, m, a, nk,dp);
            if (cur != Integer.MIN_VALUE)
                ans = Math.max(ans, 1 + cur);
        } else if (a[i][j] == 2) {
            nk = k - 1;
            int cur = help(i + 1, j, n, m, a, nk,dp);
            if (cur != Integer.MIN_VALUE)
                ans = Math.max(ans, 2 + cur);
            cur = help(i, j + 1, n, m, a, nk,dp);
            if (cur != Integer.MIN_VALUE)
                ans = Math.max(ans, 2 + cur);
        }
        return dp[i][j][k]=ans;
    }
}