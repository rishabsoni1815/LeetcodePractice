class Solution {
    public int maxDistance(int[] cs) {
        int n = cs.length, i = 0, j = n - 1;
        while (cs[0] == cs[j])
            --j;
        while (cs[n - 1] == cs[i])
            ++i;
        return Math.max(j, n - i - 1);
    }
}