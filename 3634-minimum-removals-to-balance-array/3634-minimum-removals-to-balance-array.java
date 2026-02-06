class Solution {
    public int minRemoval(int[] a, int k) {
        int n = a.length;
        Arrays.sort(a);
        int ans = n-1;
        for (int i = 0; i < n; i++) {
            int idx = cost(i, a, k);
            int c = n - idx - 1;
            c += i;//prev ele
            ans = Math.min(ans, c);
        }
        return ans;
    }

    int cost(int x, int a[], int k) {
        int l = x, r = a.length - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] <= (long) a[x] * k) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}