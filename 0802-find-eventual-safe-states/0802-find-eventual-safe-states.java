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
            if(isCycle(vis,e,i,g)==false){//basically all nodes in a cycle and that lead to a cycle are not answer and e array remains as it is as we return true as soon as we find a cycle from limne 28 so the cycle is still path visited also so checking for nodes that lead to cycle wont be n^2 as the cycyle is still path vsisited (e[i]=true) so that will return from there itlself 
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