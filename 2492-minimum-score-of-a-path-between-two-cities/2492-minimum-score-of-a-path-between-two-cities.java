class Solution {
    public int minScore(int n, int[][] a) {
        ArrayList<int []> g[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++) g[i]=new ArrayList<int []>();
        for(int i=0;i<a.length;i++){
            g[a[i][0]].add(new int[]{a[i][1],a[i][2]});
            g[a[i][1]].add(new int[]{a[i][0],a[i][2]});
        }
        HashSet<Integer>h=new HashSet<>();
        h.add(1);
        HashSet<Integer>v=new HashSet<>();
        dfs(1,h,g,v);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(h.contains(a[i][0]))ans=Math.min(ans,a[i][2]);
        }
        return ans;
    }
    void dfs(int i,HashSet<Integer>h,ArrayList<int []> g[],HashSet<Integer>v){
        v.add(i);
        for(int nei[]:g[i]){
            if(v.contains(nei[0])==false){
                h.add(nei[0]);
                dfs(nei[0],h,g,v);
            }
        }
    }
}