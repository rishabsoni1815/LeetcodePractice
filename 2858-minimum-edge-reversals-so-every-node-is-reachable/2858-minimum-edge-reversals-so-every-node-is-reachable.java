class Solution {
    //https://leetcode.com/problems/minimum-edge-reversals-so-every-node-is-reachable/discuss/4052072/c-with-explanation-dp-in-disguise-of-graph/
    public int[] minEdgeReversals(int n, int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], 0}); // normal edge, weight 0
            graph.get(edge[1]).add(new int[]{edge[0], 1}); // reverse edge, weight 1    
        }
        HashMap<String,Integer>dp=new HashMap<>();
        // Integer[][] dp = new Integer[n][n];
        int ans[]=new int[n];
        for(int i=0;i<n;i++) ans[i]=dfs(i,-1,graph,dp);
        return ans;
    }
    
    private int dfs(int u, int p, Map<Integer, List<int[]>> graph,HashMap<String,Integer>dp) {
        int res = 0;
        if(dp.containsKey(u+" o "+p)) {
            return dp.get(u+" o "+p);
        }
        for (int[] next : graph.get(u)) {
            int v = next[0], w = next[1];
            if (v == p) continue;
            
            res += dfs(v, u, graph,dp) + w;
        }
        dp.put((u+" o "+p),res);
        return res;
    }
}