class Solution {
    public int[] minBitwiseArray(List<Integer> a) {
        int n = a.size();
        //we have to find (j) the first 0 travelling from right and then set and set j-1 th bit to 0
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        for (int i = 0; i < n; i++) {
            if (a.get(i) == 2) {
                continue;
            }
            int res = -1;
            int cur = a.get(i);
            for (int j = 0; j < 32; j++) {
                if ((cur & (1 << j)) > 0) {
                    continue;
                } else {
                    res = j - 1;
                    break;
                }
            }
            if (res != -1)
                ans[i] = (cur & (~(1 << res)));
        }
        return ans;
    }
}