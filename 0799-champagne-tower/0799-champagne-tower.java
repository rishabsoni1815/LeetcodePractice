class Solution {
    double ans=0.0;
    public double champagneTower(int p, int r, int c) {
        Double dp[][]=new Double[r+2][r+2];
        return Math.min(1.0, help(p, r, c, r, c, dp));
    }
 double help(double p, int r, int c, int i, int j, Double[][] dp) {
        
        // invalid glass
        if (j < 0 || j > i) return 0.0;
        
        // reached beyond required row
        if (i > r) return 0.0;
        
        // memoized
        if (dp[i][j] != null) return dp[i][j];
        
        // top glass
        if (i == 0 && j == 0) {
            return dp[i][j] = p;
        }
        
        // amount coming from left parent
        double left = help(p, r, c, i - 1, j - 1, dp);
        double fromLeft = Math.max(0.0, (left - 1.0) / 2.0);
        
        // amount coming from right parent
        double right = help(p, r, c, i - 1, j, dp);
        double fromRight = Math.max(0.0, (right - 1.0) / 2.0);
        
        return dp[i][j] = fromLeft + fromRight;
    }
}