class Solution {
    public int maximizeSquareArea(int n, int m, int[] h, int[] v) {
        int mod = (int) (1e9 + 7);
        Arrays.sort(h);
        Arrays.sort(v);
        int a[] = new int[h.length + 1];
        int b[] = new int[v.length + 1];
        for (int i = 0; i < h.length; i++) {
            a[i] = h[i];
            if (i - 1 >=0)
                a[i] -= h[i-1];
            else
                a[i] -= 1;
        }
        a[a.length - 1] = n - h[h.length - 1];

        for (int i = 0; i < v.length; i++) {
            b[i] = v[i];
            if (i - 1 >=0)
                b[i] -= v[i-1];
            else
                b[i] -= 1;
        }
        b[b.length - 1] = m - v[v.length - 1];

        HashSet<Long> sum = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            long csum = 0L;
            for (int j = i; j < a.length; j++) {
                csum = (csum % mod + a[j]) % mod;
                sum.add(csum);
            }
        }
        long ans = -1;

        for (int i = 0; i < b.length; i++) {
            long csum = 0L;
            for (int j = i; j < b.length; j++) {
                csum = (csum % mod + b[j]) % mod;
                if (sum.contains(csum)) {
                    ans = Math.max(ans, csum);
                }
            }
        }
        return ans == -1 ? -1 : (int)(ans % mod * ans % mod) % mod;
    }
}