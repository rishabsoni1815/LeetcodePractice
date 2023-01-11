class Solution {
    public int minTime(int n, int[][] a, List<Boolean> h) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<a.length;i++){
            g.get(a[i][0]).add(a[i][1]);
            g.get(a[i][1]).add(a[i][0]);
        }
        HashSet<Integer>v=new HashSet<>();
        int ans=dfs(0,h,g,v);
        return ans==0?0:ans-2;
    }
    int dfs(int i,List<Boolean>h,ArrayList<ArrayList<Integer>>g,HashSet<Integer>v){
        v.add(i);
        int c=0;
        for(int nei:g.get(i)){
            if(!v.contains(nei)){
                c+=dfs(nei,h,g,v);
            }
        }
        if(h.get(i)==true||c!=0){
            return 2+c;
        }
        return c;
    }
}