class Solution {
    Map<Integer, int[]> h;

    public int minimumDistance(String s) {
        h = Map.ofEntries(
                Map.entry(0, new int[] { 0, 0 }),
                Map.entry(1, new int[] { 0, 1 }),
                Map.entry(2, new int[] { 0, 2 }),
                Map.entry(3, new int[] { 0, 3 }),
                Map.entry(4, new int[] { 0, 4 }),
                Map.entry(5, new int[] { 0, 5 }),
                Map.entry(6, new int[] { 1, 0 }),
                Map.entry(7, new int[] { 1, 1 }),
                Map.entry(8, new int[] { 1, 2 }),
                Map.entry(9, new int[] { 1, 3 }),
                Map.entry(10, new int[] { 1, 4 }),
                Map.entry(11, new int[] { 1, 5 }),
                Map.entry(12, new int[] { 2, 0 }),
                Map.entry(13, new int[] { 2, 1 }),
                Map.entry(14, new int[] { 2, 2 }),
                Map.entry(15, new int[] { 2, 3 }),
                Map.entry(16, new int[] { 2, 4 }),
                Map.entry(17, new int[] { 2, 5 }),
                Map.entry(18, new int[] { 3, 0 }),
                Map.entry(19, new int[] { 3, 1 }),
                Map.entry(20, new int[] { 3, 2 }),
                Map.entry(21, new int[] { 3, 3 }),
                Map.entry(22, new int[] { 3, 4 }),
                Map.entry(23, new int[] { 3, 5 }),
                Map.entry(24, new int[] { 4, 0 }),
                Map.entry(25, new int[] { 4, 1 }));
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        Integer dp[][][] = new Integer[n][26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ans = Math.min(ans, help(0, i, j, s, dp));
            }
        }
        return ans;
    }

    int help(int i, int f, int s, String st, Integer dp[][][]) {
        if (i == st.length())
            return 0;
        if (dp[i][f][s] != null)
            return dp[i][f][s];
        int c1[] = h.get(f);
        int c2[] = h.get(s);
        int c[] = h.get(st.charAt(i) - 'A');
        int dis1 = (int) (Math.abs(c[0] - c1[0]) + Math.abs(c[1] - c1[1]));
        int dis2 = (int) (Math.abs(c[0] - c2[0]) + Math.abs(c[1] - c2[1]));
        int ans = dis1 + help(i + 1, st.charAt(i) - 'A', s, st, dp);
        ans = Math.min(ans, dis2 + help(i + 1, f, st.charAt(i) - 'A', st, dp));
        return dp[i][f][s] = ans;
    }
}