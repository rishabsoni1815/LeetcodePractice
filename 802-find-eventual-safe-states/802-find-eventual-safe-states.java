class Solution {
    public List<Integer> eventualSafeNodes(int[][] a) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            ArrayList<Integer>y=new ArrayList<>();
            for(int j=0;j<a[i].length;j++){
                y.add(a[i][j]);
            }
            g.add(y);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        boolean vis[]=new boolean[a.length];
        boolean e[]=new boolean[a.length];
        for(int i=0;i<a.length;i++){
            if(isCycle(vis,e,i,g)==false){//basically all nodes in a cycle are not answer
                ans.add(i);
            }
        }
        return ans;
    }
    boolean isCycle(boolean vis[],boolean e[],int i,ArrayList<ArrayList<Integer>>g){
        vis[i]=true;
        e[i]=true;
        for(int nei:g.get(i)){
            if(vis[nei]==false){
                if(isCycle(vis,e,nei,g)) return true;
            }else{
                if(e[nei]==true){
                    return true;
                }
            }
        }
        e[i]=false;
        return false;
    }
}