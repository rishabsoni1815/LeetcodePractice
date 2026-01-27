class Solution {
    public int minCost(int n, int[][] a) {
        ArrayList<ArrayList<int[]>> g = new ArrayList<>();//0-> vertex,1->edge, 2->weight
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < a.length; i++) {
            g.get(a[i][0]).add(new int[] { a[i][1], a[i][2] });
            g.get(a[i][1]).add(new int[] { a[i][0], 2 * a[i][2] });
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> (x[1] - y[1]));//min at top
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        q.add(new int[] { 0, 0 });
        dis[0] = 0;
        while (q.size() > 0) {
            int c[] = q.poll();
            for (int nei[] : g.get(c[0])) {
                if (dis[nei[0]] > c[1] + nei[1]) {
                    dis[nei[0]] = c[1] + nei[1];
                    q.add(new int[] { nei[0], dis[nei[0]] });
                }
            }
        }
        return dis[n-1]==Integer.MAX_VALUE?-1:dis[n-1];
    }
}