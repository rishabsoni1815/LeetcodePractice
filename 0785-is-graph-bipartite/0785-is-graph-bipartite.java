class Solution {
    public boolean isBipartite(int[][] a) {
        int n=a.length;
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<a[i].length;j++){
                g.get(i).add(a[i][j]);
                g.get(a[i][j]).add(i);
            }
        }
        int h[]=new int[n];
        HashSet<Integer>v=new HashSet<>();
        for(int i=0;i<n;i++){
            if(!v.contains(i)){
                if(dfs(i,g,v,h)==false) return false;
            }
        }
        return true;
    }
    boolean dfs(int i,ArrayList<ArrayList<Integer>>g,HashSet<Integer>v,int h[]){
        v.add(i);
        for(int nei:g.get(i)){
            if(!v.contains(nei)){
                v.add(nei);
                h[nei]=1-h[i];
                if(dfs(nei,g,v,h)==false) return false;
            }else{
                if(h[nei]==h[i]) return false;
            }
        }
        return true;
    }
}