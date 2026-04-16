class Solution {
    public List<Integer> solveQueries(int[] a, int[] q) {
        HashMap<Integer, TreeSet<Integer>> h = new HashMap<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            h.computeIfAbsent(a[i], value -> new TreeSet<>()).add(i);
        }
        HashMap<Integer, Integer> ans = new HashMap<>();
        List<Integer> alist = new ArrayList<>();
        for (int i = 0; i < q.length; i++) {
            TreeSet<Integer> c = h.get(a[q[i]]);
            if(c.size()==1){
                alist.add(-1);
                continue;
            }
            int cans = Integer.MAX_VALUE;
            Integer big = c.higher(q[i]);
            Integer small = c.lower(q[i]);

            // wrap forward
            if (big == null)
                big = c.first();

            // wrap backward
            if (small == null)
                small = c.last();

            int d1 = Math.abs(q[i] - big);
            int d2 = Math.abs(q[i] - small);

            cans = Math.min(cans,
                    Math.min(d1, n - d1));

            cans = Math.min(cans,
                    Math.min(d2, n - d2));

            alist.add(cans==Integer.MAX_VALUE?-1:cans);
        }
        return alist;
    }
}