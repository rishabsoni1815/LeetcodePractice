class Solution {
    int ans=-1;
    public int longestCycle(int[] e) {
        ans=-1;
        int n=e.length;
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
           if(e[i]!=-1) g.get(i).add(e[i]);
        }
        boolean v[]=new boolean[n];
        int dis[]=new int[n];
        boolean cur[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(v[i]==false){
                dis[i]=1;
                dfs(i,g,v,cur,dis);
            }
        }
        return ans;
    }
    void dfs(int i,ArrayList<ArrayList<Integer>>g,boolean v[],boolean cur[],int dis[]){
        v[i]=true;
        cur[i]=true;
        for(int nei:g.get(i)){
            if(v[nei]==false){
                dis[nei]=dis[i]+1;
                dfs(nei,g,v,cur,dis);
            }else if(cur[nei]==true){
                // System.out.println("cycle "+dis[nei]+" "+dis[i]+" "+nei+" "+i);
                ans=Math.max(ans,Math.abs(dis[nei]-dis[i])+1);
            }
        }
        cur[i]=false;
    }
}