class Solution {
    public boolean isBipartite(int[][] a) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            ArrayList<Integer>c=new ArrayList<>();
            for(int j=0;j<a[i].length;j++){
                c.add(a[i][j]);
            }
            g.add(c);
        }
        HashMap<Integer,Integer>v=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(!v.containsKey(i)){
                if(dfs(i,0,g,v)==false) return false;
            }
        }
        return true;
    }
    boolean dfs(int i,int c,ArrayList<ArrayList<Integer>>g,HashMap<Integer,Integer>v){
        v.put(i,c);
        for(int nei:g.get(i)){
            if(!v.containsKey(nei)){
                if(dfs(nei,1-c,g,v)==false) return false;
            }else{
                if(v.get(nei)==c) return false;
            }
        }
        return true;
    }
}