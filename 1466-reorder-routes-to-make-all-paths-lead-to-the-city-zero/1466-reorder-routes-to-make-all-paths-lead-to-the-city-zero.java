class Solution {
    public int minReorder(int n, int[][] connections) {
        /*
          first make edges both sided then do bfs from 0 then if edgi is not from child to parent then ans++
          https://youtu.be/cU47iO_Q70g?t=510
        */
        Set<String> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int count  = 0;

        for(int i=0;i<n;i++)
        {
            map.put(i, new HashSet<>());
        }

        for(int i=0;i<connections.length;i++)
        {
            int src = connections[i][0];
            int dest = connections[i][1];

            String s = src + "," + dest;
            set.add(s);

            map.get(src).add(dest);
            map.get(dest).add(src);
        }
        return dfs(map, set, new boolean[n], 0);
    }
    public int dfs(Map<Integer, Set<Integer>> map, Set<String> set, boolean visited[], int src)
        {

            int count = 0;
            if(visited[src]) return 0;
            visited[src] = true;

            for(int s : map.getOrDefault(src, new HashSet<>()))
            {
                if(visited[s]) continue;
                if(!set.contains(s + "," + src)) count++;
                count+=dfs(map, set, visited,s);
            }

            return count;
        }
}