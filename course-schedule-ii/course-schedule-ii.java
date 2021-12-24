class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
            int[] indegree = new int[numCourses];
            int[] topologicalOrder = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
              int dest = prerequisites[i][0];
              int src = prerequisites[i][1];
              List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
              lst.add(dest);
              adjList.put(src, lst);
              indegree[dest] += 1;
            }

            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; i++) {
              if (indegree[i] == 0) {
                q.add(i);
              }
            }

            int i = 0;
            while (!q.isEmpty()) {
              int node = q.remove();
              topologicalOrder[i++] = node;
              if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                  indegree[neighbor]--;
                  if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                  }
                }
              }
            }
            if (i == numCourses) {
              return topologicalOrder;
            }

            return new int[0];
    }
    
    
    // this method not work as we need to check if it's possible i.e 
    // if it's a DAG so indegree method checkd for cycles so use that 
    // as not guaranteed if there is a topo sort possible for array
    // void dfs(Stack<Integer>ans,int node,ArrayList<ArrayList<Integer>>g,HashSet<Integer>v){
    //     v.add(node);
    //     for(int nei:g.get(node)){
    //         if(v.contains(nei)) continue;
    //         dfs(ans,nei,g,v);
    //     }
    //         ans.add(node);
    // }
}