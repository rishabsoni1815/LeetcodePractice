class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            ans = ans << 1;
            if ((n & (1 << i)) > 0)
                ans += 1;
        }
        return ans;
    }
}