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
        return ans;
    }
    void dfs(int node, int parent, int vis[], int tin[], int low[], List<List<Integer>> adj, int timer, List<List<Integer>> ans) {
		vis[node] = 1; //visited marked
		tin[node] = low[node] = timer++; //time inc so timer++ low ans tin both initialised by times

		for(Integer it: adj.get(node)) {
			if(it == parent) continue; //as we won't update low for parent

			if(vis[it] == 0) {//unvisited so make a dfs
				dfs(it, node, vis, tin, low, adj, timer,ans); 
				if(low[it] > tin[node]) {// check as a parent if my this neighbour and mine's edge is a bridge if low[it]>=tin[node] then it ins't a bridge low[it]-> lowest time in neighbours except parent
                    List<Integer>temp=new ArrayList<>();
                    temp.add(it);
                    temp.add(node);
                    ans.add(new ArrayList<>(temp));
				}
				low[node] = Math.min(low[node], low[it]); //update by lowest time from all my neighbour
			} else {
				low[node] = Math.min(low[node], tin[it]); //visited but still i can update my lowest time
			}
		}
	}
    void printBridges(List<List<Integer>> adj, int n, List<List<Integer>> ans)
    {
        int vis[] = new int[n]; 
        int tin[] = new int[n];//finding time (first visit time)
        int low[] = new int[n];//lowest time in neighbours except parent

        int timer = 0; 
        for(int i = 0;i<n;i++) {
        	if(vis[i] == 0) {
        		dfs(i, -1, vis, tin, low, adj, timer,ans); 
        	}
        }
    }
}