class Solution {
   public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] memo = new Integer[piles.size() + 1][k + 1];

        return dp(piles, memo, 0, k);
    }
    public int dp(List<List<Integer>> piles, Integer[][] memo, int i, int k) {
        if (k == 0 || i == piles.size()) return 0;
        if (memo[i][k] != null) return memo[i][k];

        int res = dp(piles, memo, i + 1, k);//not taking from this pile
        int cur = 0;

        for (int j = 0; j < Math.min(piles.get(i).size(), k); ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, cur + dp(piles, memo, i + 1, k - j - 1));//taking some no. of items(j items) from this pile and checking for every count by doing i+1
        }
        return memo[i][k] = res;
    }
}