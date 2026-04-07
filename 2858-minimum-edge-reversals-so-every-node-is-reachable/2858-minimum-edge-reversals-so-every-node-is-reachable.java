class Solution {
    /*
    When root moves across an edge,
    Only that edge changes meaning.
    Everything else stays same.
    So we:
    Adjust +1 or -1
    Instead of recomputing
    That's rerooting.
    */

    List<int[]>[] graph;
    int[] ans;

    public int[] minEdgeReversals(int n, int[][] edges) {

        // Build graph
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        // Add edges with direction cost
        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];

            graph[u].add(new int[] { v, 0 }); // original direction
            graph[v].add(new int[] { u, 1 }); // reverse direction
        }

        ans = new int[n];

        // Step 1: find answer for root = 0
        dfs1(0, -1);

        // Step 2: reroot and compute others
        dfs2(0, -1);

        return ans;
    }

    // First DFS:
    // Count reversals needed if root = 0
    private void dfs1(int u, int parent) {

        for (int[] edge : graph[u]) {

            int v = edge[0];
            int w = edge[1];

            if (v == parent)
                continue;

            ans[0] += w;

            dfs1(v, u);
        }
    }

    // Second DFS:
    // Rerooting step
    private void dfs2(int u, int parent) {

        for (int[] edge : graph[u]) {

            int v = edge[0];
            int w = edge[1];

            if (v == parent)
                continue;

            if (w == 0)
                ans[v] = ans[u] + 1;
            else
                ans[v] = ans[u] - 1;

            dfs2(v, u);
        }
    }
}