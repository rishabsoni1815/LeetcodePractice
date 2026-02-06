class Solution {
    public int minRemoval(int[] a, int k) {
        int n = a.length;
        Arrays.sort(a);
        int ans = n-1;
        // for (int i = 0; i < n; i++) {
        //     int idx = cost(i, a, k);
        //     int c = n - idx - 1;
        //     c += i;//prev ele
        //     ans = Math.min(ans, c);
        // }


        //greedy 2 pointer first inc right pointer then no choice left so inc l and take min
        int i=0,j=0;
        while(i<n){
            while(j<n && (long)a[i]*k>=a[j]){
                j++;
            }
            ans=Math.min(ans,i+n-j);
            i++;
        }
        return ans;
    }

//binary search
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