class Solution {
    public int findCircleNum(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(a[i][j]==1){
                        g.get(i).add(j);
                    }
                }
            }
        }
        HashSet<Integer>v=new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(v.contains(i)==false){
                ans++;
                dfs(g,i,v);
            }
        }
        return ans;
    }
    void dfs(ArrayList<ArrayList<Integer>>g,int i,HashSet<Integer>v){
        v.add(i);
        for(int nei:g.get(i)){
            if(v.contains(nei)==false){
                dfs(g,nei,v);
            }
        }
    }
}