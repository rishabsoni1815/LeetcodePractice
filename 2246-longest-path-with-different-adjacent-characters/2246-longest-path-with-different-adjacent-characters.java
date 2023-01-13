class Solution {
    int ans=0;
    public int longestPath(int[] p, String s) {
        this.ans=0;
        int n=p.length;
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=1;i<n;i++){
            g.get(p[i]).add(i);
        }
        dfs(0,g,s);
        return ans;
    }
    int dfs(int i,ArrayList<ArrayList<Integer>>g,String s){
        int max=0,smax=0;
        for(int nei:g.get(i)){
            int x=dfs(nei,g,s);
            if(s.charAt(nei)!=s.charAt(i)){
                if(x>=max){
                    smax=max;
                    max=x;
                }else if(x>smax){
                    smax=x;
                }
            }
        }
        ans=Math.max(ans,1+max+smax);
        return 1+max;
    }
}