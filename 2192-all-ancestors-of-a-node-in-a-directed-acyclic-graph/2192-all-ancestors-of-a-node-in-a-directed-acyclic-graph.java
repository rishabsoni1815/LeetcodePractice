class Solution {
        TreeSet<Integer> ans[]=new TreeSet[1000];
    public List<List<Integer>> getAncestors(int n, int[][] e) {
        ans=new TreeSet[n];
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
            ans[i]=new TreeSet<Integer>();
        }
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(e[i][1]);
        }
        Stack<Integer> st = new Stack<Integer>(); 
        int vis[] = new int[n]; 
        
        for(int i = 0;i<n;i++) {
            if(vis[i] == 0) {
                findTopoSort(i, vis, g, st);
            }
        }
        
        int topo[] = new int[n];
        int ind = 0; 
        while(!st.isEmpty()) {
            topo[ind++] = st.pop();
        }
        for(int i=0;i<n;i++){
            for(int nei:g.get(topo[i])){
                for(int o:ans[topo[i]]){
                    ans[nei].add(o);
                }
                ans[nei].add(topo[i]);
            }
        }
        List<List<Integer>>ansl=new ArrayList<>();
        for(int i=0;i<n;i++){
            ansl.add(new ArrayList<>());
            for(int k:ans[i]){
                ansl.get(i).add(k);
            }
        }
        return ansl;
    }
    void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1; 
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                findTopoSort(it, vis, adj, st); 
            } 
        }
        st.push(node); 
    }
}
/*

O(n^2)
Idea is simple if you start from any node then the node that you will be visiting will have start node as an ancestor.
Let us understand with an example.
Let's say i start from node 0 and i have visited node 1 node 3 and node 4
so node 0 will be ancestor of all node 1,3 and 4

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n], res = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
        }
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, i, graph, visited, res);
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            answer.add(res[i]);
        }
        return answer;
    }
    
    //          originalSource, neighbour, graph, visited
    public void dfs(int osrc, int next, ArrayList<Integer>[] graph, boolean[] visited, ArrayList<Integer>[] res) {
        visited[next] = true;
        for (int nbr : graph[next]) {
            if (!visited[nbr]) {
                res[nbr].add(osrc);
                dfs(osrc, nbr, graph, visited, res);
            }
        }
    }
}

*/