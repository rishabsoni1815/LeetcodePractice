
class DisjointSet {
    
    private int[] parent;
    private int[] rank;
    
    public DisjointSet(int n) {
        if (n < 0) throw new IllegalArgumentException();
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        rank = new int[n];
    }
    
    public void reset(int x) {
    	parent[x]=x;
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
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
        return true;
    }
}
class Solution {
    	public List<Integer> findAllPeople(int t, int[][] a, int f) {
        int n=a.length;
        DisjointSet g=new DisjointSet(t);
        Arrays.sort(a,(x,y)->(x[2]-y[2]));
        HashSet<Integer>ans=new HashSet<>();
        ans.add(0);
        ans.add(f);
        g.union(0,f);
        for(int i=0;i<n;){
            int x=a[i][0];int y=a[i][1];int ct=a[i][2];
            int j=i;HashSet<Integer>temp=new HashSet<>();
            while(j<n&&a[j][2]==ct){
	            g.union(a[j][0],a[j][1]);temp.add(a[j][0]);temp.add(a[j][1]);
                j++;
            }
            i=j;
            for(int o:temp){
                if(g.find(o)==g.find(f)) {
                	ans.add(o);
                }else{
                    g.reset(o);//resetting as they don't know secret so there this t's connnection will be stored in dsu and then in next time if they come it will effect our answer
                }
            }
        }
        List<Integer>l=new ArrayList<Integer>();
        for(int u:ans)l.add(u);
        return l;
    }
}