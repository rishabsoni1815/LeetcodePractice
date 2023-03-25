class Solution {
    long cnt=0;
    public long countPairs(int n, int[][] e) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(e[i][1]);
            g.get(e[i][1]).add(e[i][0]);
        }
        ArrayList<Long>ans=new ArrayList<>();
        HashSet<Integer>v=new HashSet<>();
        for(int i=0;i<n;i++){
            if(v.contains(i)==false){
                v.add(i);
                cnt=1;
                dfs(i,g,v);
                ans.add(cnt);
            }
        }
        if(ans.size()==1) return 0L;
        long prev=0;
        long res=0;prev=ans.get(0);
        // if(ans.size()==n) {
        //     return (long)(n*(n-1))/2;
        // }
        for(int i=1;i<ans.size();i++){
                res+=(long)(prev*ans.get(i));
                prev+=ans.get(i);
        }
        return (long)res;
    }
    void dfs(int i,ArrayList<ArrayList<Integer>>g,HashSet<Integer>v){
        for(int nei:g.get(i)){
            if(v.contains(nei)==false){
                cnt++;
                v.add(nei);
                dfs(nei,g,v);
            }
        }
    }
}