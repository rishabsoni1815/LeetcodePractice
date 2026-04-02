class Solution {
    public int maximumDetonation(int[][] a) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        int n=a.length;
        for(int i=0;i<n;i++) g.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(reachable(i,j,a) && i!=j){
                    g.get(i).add(j);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            HashSet<Integer>v=new HashSet<>();
            dfs(i,g,v);
            max=Math.max(max,v.size());
        }
        return max;
    }
    boolean reachable(int i,int j,int a[][]){
        long x1=a[i][0];
        long y1=a[i][1];
        long x2=a[j][0];
        long y2=a[j][1];
        long d=(long)((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        return d<=((long)(a[i][2])* (a[i][2]));
    }
    void dfs(int i,ArrayList<ArrayList<Integer>>g,HashSet<Integer>v){
        v.add(i);
        for(int nei:g.get(i)){
            if(!v.contains(nei)) {
                dfs(nei,g,v);
            }
        }
    }
}