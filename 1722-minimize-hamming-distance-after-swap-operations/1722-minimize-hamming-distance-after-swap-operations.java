import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] s, int[] t, int[][] a) {

        int n = s.length;

        // Build graph
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < a.length; i++) {
            g.get(a[i][0]).add(a[i][1]);
            g.get(a[i][1]).add(a[i][0]);
        }

        // Find connected components
        ArrayList<HashSet<Integer>> com = new ArrayList<>();
        HashSet<Integer> v = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!v.contains(i)) {
                HashSet<Integer> cur = new HashSet<>();
                dfs(i, g, v, cur);
                com.add(cur);
            }
        }

        int res = n;

        // Process each component
        for (HashSet<Integer> comp : com) {

            HashMap<Integer, Integer> countS = new HashMap<>();
            HashMap<Integer, Integer> countT = new HashMap<>();

            // Count frequencies
            for (int idx : comp) {
                countS.put(s[idx],
                        countS.getOrDefault(s[idx], 0) + 1);

                countT.put(t[idx],
                        countT.getOrDefault(t[idx], 0) + 1);
            }

            // Find matches
            for (int key : countS.keySet()) {

                if (countT.containsKey(key)) {

                    int matches = Math.min(
                            countS.get(key),
                            countT.get(key)
                    );

                    res -= matches;
                }
            }
        }

        return res;
    }

    void dfs(int i,
             ArrayList<ArrayList<Integer>> g,
             HashSet<Integer> v,
             HashSet<Integer> cur) {

        v.add(i);
        cur.add(i);

        for (int nei : g.get(i)) {

            if (!v.contains(nei)) {
                dfs(nei, g, v, cur);  // FIXED
            }
        }
    }
}