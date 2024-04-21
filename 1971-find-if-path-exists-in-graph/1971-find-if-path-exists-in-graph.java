class Solution {
    public boolean validPath(int n, int[][] e, int s, int d) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(e[i][1]);
            g.get(e[i][1]).add(e[i][0]);
        }
        HashSet<Integer>v=new HashSet<>();
        dfs(g,s,v);
        if(v.contains(d)) return true;
        return false;
    }
    void dfs(ArrayList<ArrayList<Integer>>g,int s,HashSet<Integer>v){
        v.add(s);
        for(int nei:g.get(s)){
            if(v.contains(nei)==false){
                dfs(g,nei,v);
            }
        }
    }
}