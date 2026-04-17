class Solution {
    public int minMirrorPairDistance(int[] a) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int rev = rev(a[i]);
            if (h.containsKey(a[i])) {
                ans = Math.min(ans, i - h.get(a[i]));
            }
            h.put(rev, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int rev(int x) {
        int y = 0;
        while (x > 0) {
            y = (y * 10 + x % 10);
            x /= 10;
        }
        return y;
    }
}