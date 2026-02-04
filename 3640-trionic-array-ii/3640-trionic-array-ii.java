class Solution {
    long NEG_INF = -(long)1e15;
    Long dp[][][]; // 3D DP: [index][phase][count_started]

    public long maxSumTrionic(int[] a) {
        // c is mapped to 0 (just started) or 1 (ongoing), so size 2 is enough
        dp = new Long[a.length][3][2];
        return help(a, 0, 0, 0);
    }

    // Returns: Max sum of a valid sequence part starting from index i
    long help(int a[], int i, int t, int c) {
        if (i >= a.length) {
            return NEG_INF;
        }

        // Clamp c to 1 for memoization (we only care if c > 0)
        int cKey = (c > 0) ? 1 : 0;
        
        if (dp[i][t][cKey] != null) return dp[i][t][cKey];

        long ans = NEG_INF;

        // OPTION 1: SKIP / RESET
        // We can only ignore a[i] and start fresh if we haven't started a sequence yet (t=0, c=0)
        if (t == 0 && c == 0) {
            ans = Math.max(ans, help(a, i + 1, 0, 0));
        }

        // OPTION 2: INCLUDE a[i]
        // 2a. Can we end the sequence here? (Only if in final phase t=2 and length > 0)
        if (t == 2 && c > 0) {
            // Ending here means the "future sum" from this point is just a[i]
            ans = Math.max(ans, (long)a[i]);
        }

        // 2b. Can we extend the sequence?
        long nextVal = NEG_INF;
        
        if (i + 1 < a.length) { // Check bounds for i+1
            if (t == 0) {
                if (a[i + 1] > a[i]) {
                    nextVal = Math.max(nextVal, help(a, i + 1, 0, 1));
                } else if (a[i + 1] < a[i] && c > 0) {
                    nextVal = Math.max(nextVal, help(a, i + 1, 1, 1));
                }
            } else if (t == 1) {
                if (a[i + 1] < a[i]) {
                    nextVal = Math.max(nextVal, help(a, i + 1, 1, 1));
                } else if (a[i + 1] > a[i] && c > 0) {
                    nextVal = Math.max(nextVal, help(a, i + 1, 2, 1));
                }
            } else if (t == 2) {
                if (a[i + 1] > a[i]) {
                    nextVal = Math.max(nextVal, help(a, i + 1, 2, 1));
                }
            }
        }

        // If extension was valid, add current a[i] to the best future result
        if (nextVal != NEG_INF) {
            ans = Math.max(ans, a[i] + nextVal);
        }

        return dp[i][t][cKey] = ans;
    }
}