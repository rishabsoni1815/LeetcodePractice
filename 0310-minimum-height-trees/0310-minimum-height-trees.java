class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //this is like finding center of tree i.e. if array then we will two pointers and do i++ j-- until we met simlarly we will firstly get the leaves of graph then inner ones then inner until 1/2 nodes are left (do bfs)
        List<List<Integer>> myGraph = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        if (n==1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        for(int i=0; i<n; i++) {
            myGraph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++) {
            myGraph.get(edges[i][0]).add(edges[i][1]);
            myGraph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.offer(i);
        }
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                list.add(cur);
                for (int parent : myGraph.get(cur)) {
                    degree[parent]--;
                    if (degree[parent]== 1) q.offer(parent);
                }
            }
            res = list;
        }
        return res;
    }
}