class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        int min = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        List<Integer> list = new ArrayList<>();
        int taken=0;
        for (int[] edge : edges) {
            if (edge[3] == 0) { // offer all 0-edges in maxHeap
                pq.offer(edge);
            }
            else { // union all 1-edges as must!
                if (!dsu.union(edge[0], edge[1])) {
                    return -1;
                }
                taken++;
                min = Math.min(min, edge[2]);                
            }
        } // MST pruning in while loop is 2x faster
        while (!pq.isEmpty() && taken < n) {
            int[] edge = pq.poll();
            if (dsu.union(edge[0], edge[1])) {
                taken++;
                list.add(edge[2]);
            } // union the largest 0-edges until MST formed!
        }
        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
            list.set(i, 2 * list.get(i));
            k--; 
        } // of those who made the MST, double the 'k' smallest ones
        for (int i : list) {
            min = Math.min(min, i);
        }
        return taken != n-1 ? -1 : min;
    }
    class DSU {
        int[] size, parent;
        int componentCount;

        public DSU(int n) {
            size = new int[n];
            parent = new int[n];
            componentCount = n;
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        public boolean union(int u, int v) {
            int pu = findParent(u), pv = findParent(v);
            if (pu == pv) {
                return false;
            }
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            componentCount--;
            return true;
        }
    }
}