class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // not the connected components as in directed graph there are strongly connected components not simple and scc wont help us in thsi so ans is vertices with indegree 1
        int in[]=new int[n];
        List<Integer>ans=new ArrayList<>();
        for(List<Integer>edge:edges){
            in[edge.get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(in[i]==0) ans.add(i);
        }
        return ans;
    }
}