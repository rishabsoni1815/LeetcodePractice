class Solution {
    /*
    
    Do it in two directions.
    The first loop makes sure children with a higher rating get more candy than its left neighbor; the second loop makes sure children with a higher rating get more candy than its right neighbor.
    
    */

    public int candy(int[] a) {
        int n = a.length;
        int dp[] = new int[n];
        int sum = 0;
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            if(a[i]>a[i-1]) dp[i] = Math.max(dp[i], dp[i - 1] + 1);//adding only 1 since we want to minimise the no of candies
        }
        for (int i = n - 2; i >= 0; i--) {
            if(a[i]>a[i+1]) dp[i] = Math.max(dp[i], dp[i + 1] + 1);//taking max since we want both conditions to satisfy (i's candies are >right and >left person)
        }
        for (int i : dp)
            sum+=i;
        return sum;
    }
}