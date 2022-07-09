class Solution {
        int curnumOfStones = 0;
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet();
        int ans=0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
                curnumOfStones=0;
               dfs(s1, visited, stones); 
                ans+=curnumOfStones-1;//as this sorce of dfs is not removed its connected component neighbours are
            }
        }
        return ans;
    }
    
    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        curnumOfStones++;
        for (int[] s2: stones){
            if (!visited.contains(s2)){
				// stone with same row or column. group them into island
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
}