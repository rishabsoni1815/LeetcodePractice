class Solution {
    public boolean isTrionic(int[] a) {
        int n = a.length;
        // if (n < 4)
        //     return false;
        boolean inc = true;
        int cnt = 0,cur=0;
        for (int i = 1; i < n; i++) {
            if(a[i]==a[i-1]) return false;
            if (inc) {
                if (a[i] <=a[i - 1]) {
                    if(cur<1) return false;
                    cnt++;
                    inc = false;
                    cur=0;
                }
                cur++;
            } else {
                if (a[i] > a[i - 1]) {
                    if(cur<1) return false;
                    cnt++;
                    cur=0;
                    inc = true;
                }
                cur++;
            }
            // System.out.println(i + " " + cnt + " " + inc);
        }
        return cnt == 2 && cnt>0;
    }
}