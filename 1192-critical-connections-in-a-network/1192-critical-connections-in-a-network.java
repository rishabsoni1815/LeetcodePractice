class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>>ans=new ArrayList<>();
        List<List<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<connections.size();i++){
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            g.get(u).add(v);
            g.get(v).add(u);
        }
        printBridges(g, n,ans);
        // System.out.println(ans.size());
        return ans;
    }
    void dfs(int node, int parent, int vis[], int tin[], int low[], List<List<Integer>> adj, int timer, List<List<Integer>> ans) {
		vis[node] = 1; 
		tin[node] = low[node] = timer++; 

		for(Integer it: adj.get(node)) {
			if(it == parent) continue; 

			if(vis[it] == 0) {
				dfs(it, node, vis, tin, low, adj, timer,ans); 
				low[node] = Math.min(low[node], low[it]); 

				if(low[it] > tin[node]) {
                    List<Integer>temp=new ArrayList<>();
                    temp.add(it);
                    temp.add(node);
                    ans.add(new ArrayList<>(temp));
					// System.out.println(it + " " +node); 
                     // System.out.println(ans.size());
				}
			} else {
				low[node] = Math.min(low[node], tin[it]); 
			}
		}
	}
    void printBridges(List<List<Integer>> adj, int n, List<List<Integer>> ans)
    {
        int vis[] = new int[n]; 
        int tin[] = new int[n];
        int low[] = new int[n]; 

        int timer = 0; 
        for(int i = 0;i<n;i++) {
        	if(vis[i] == 0) {
        		dfs(i, -1, vis, tin, low, adj, timer,ans); 
        	}
        }
    }
}