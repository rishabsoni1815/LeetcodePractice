class Solution {
    public int makeConnected(int n, int[][] a) {
        if(a.length<n-1) return -1;
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<a.length;i++){
            g.get(a[i][0]).add(a[i][1]);
            g.get(a[i][1]).add(a[i][0]);
        }
        HashSet<Integer>v=new HashSet<>();
        int ans=-1;
        for(int i=0;i<n;i++){
           if(v.contains(i)==false) {
               dfs(i,n,g,v);
               ans++;
           }
        }
        return ans;
    }
        void dfs(int i,int n,ArrayList<ArrayList<Integer>>g,HashSet<Integer>v){
            if(i>n||v.contains(i)){
                return;
            }
            v.add(i);
            for(int nei:g.get(i)){
                dfs(nei,n,g,v);
            }
        }
}