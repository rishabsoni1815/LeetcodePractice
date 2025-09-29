class Solution {
    public int minScoreTriangulation(int[] arr) {
        //pepcoding video   https://www.youtube.com/watch?v=tmIhmeL8WRo
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int g = 0 ; g < n ; g++)
        {
            for(int i = 0 , j = g; j<n ; i++, j++)
            {            
                if(g==0 || g == 1)
                {
                    dp[i][j] = 0;
                }
                else if(g == 2)
                {
                    dp[i][j] = arr[i] * arr[i+1] * arr[i+2];
                }
                else
                {
                    int min = Integer.MAX_VALUE;
                    int pro = arr[i]*arr[j];
                    for(int k = i+1 ; k<=j-1; k++)
                    {
                        int tpro = pro * arr[k];
                        int m1 = dp[i][k];
                        int m2 = dp[k][j];

                        min = Math.min(min, tpro + m1 + m2);
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][n-1];
    }
}