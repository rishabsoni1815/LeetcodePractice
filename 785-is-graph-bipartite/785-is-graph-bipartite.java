class Solution {
    public boolean isBipartite(int[][] g) {
        //dfs
       int n=g.length;
       boolean v[]=new boolean[n];
       int col[]=new int[n];Arrays.fill(col,-1); 
       for(int i=0;i<n;i++){
           if(v[i]==false){
               col[i]=0;
               if(dfs(i,v,g,col)==false) return false;
           }
       }
       return true;
    }
    boolean dfs(int i,boolean v[],int g[][],int col[]){
        v[i]=true;
        for(int k=0;k<g[i].length;k++){
            int nei=g[i][k];
            if(v[nei]==false){
                col[nei]=1-col[i];
                if(dfs(nei,v,g,col)==false) return false;
            }else{
                if(col[nei]==col[i]) return false;
            }
        }
        return true;
    }
    
    
    
    // public boolean isBipartite(int[][] g) {
    //     //bfs
    //     int n=g.length;
    //    boolean v[]=new boolean[n];
    //     int col[]=new int[n];
    //     Arrays.fill(col,-1);
    //     // Code here
    //     for(int i=0;i<n;i++){
    //         if(v[i]==false){
    //             Queue<Integer>q=new LinkedList<>();
    //             q.add(i);
    //             v[i]=true;
    //             col[i]=0;
    //             while(!q.isEmpty()){
    //                 int t=q.poll();
    //                 for(int k=0;k<g[t].length;k++){
    //                     int nei=g[t][k];
    //                     if(v[nei]==false){
    //                         v[nei]=true;
    //                         q.add(nei);
    //                         col[nei]=1-col[t];
    //                     }
    //                     else{
    //                         if(col[nei]==col[t]) return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
}