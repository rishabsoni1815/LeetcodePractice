class Solution {
    public int minSubarray(int[] a, int p) {
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum+a[i])%p;
        }
        int t = sum % p;
        if (t == 0)
            return 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0, -1);
        int csum = 0, ans = n;
        for (int i = 0; i < n; i++) {
            csum = (csum + a[i]) % p;
            int tar = (csum - t + p) % p;
            if (h.containsKey(tar)) {
                ans = Math.min(ans, i - h.get(tar));
            }
            h.put(csum % p, i);
        }
        return ans == n ? -1 : ans;
    }
}
// (csumi - csumj)%p = t
//csum = (csumi-t)%p to remove negative remainder +p %p