class Solution {
    public boolean equationsPossible(String[] a) {
        
        // dfs is very long and complex and has many cond. of !,== ,undirected graph etc so use DSU
        
        DisjointSet dsu=new DisjointSet(26);
        for(int i=0;i<a.length;i++){
            String t=a[i];
            if(t.charAt(1)=='='){
                dsu.union(t.charAt(0)-'a',t.charAt(3)-'a');
            }
        }
         for(int i=0;i<a.length;i++){
            String t=a[i];
            if(t.charAt(1)=='!'){
                if(dsu.find(t.charAt(0)-'a')==dsu.find(t.charAt(3)-'a')) return false;//use find not parent array
            }
        }
            
        return true;
    }
     static class DisjointSet {
        
        private int[] parent;
        private int[] rank;
        
        public DisjointSet(int n) {
            if (n < 0) throw new IllegalArgumentException();
            parent = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
            rank = new int[n];
        }
        
        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]); // Path compression by halving.
        }
        
        // Return false if x, y are connected.
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            
            // Make root of smaller rank point to root of larger rank.
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            
            return true;
        }
    }
}