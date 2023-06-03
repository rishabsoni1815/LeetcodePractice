class Solution {
    //dfs and maintaining time at each step
    int max=Integer.MIN_VALUE;
    public int numOfMinutes(int n, int i, int[] p, int[] t) {
        boolean visited[]=new boolean [n];
        HashMap<Integer,ArrayList<Integer>>h=new HashMap<>();
        for(int j=0;j<n;j++){
            h.put(j,new ArrayList<>());
        }
        for(int j=0;j<n;j++){
            if(j!=i){
                h.get(p[j]).add(j);
            }
        }
        max=Integer.MIN_VALUE;
        dfs(n,i,h,t,t[i],visited);
        return max;
    }
    void dfs(int n,int i,HashMap<Integer,ArrayList<Integer>> h,int t[],int c,boolean visited[]){
        visited[i]=true;
        max=Math.max(max,c);
        for(int nei:h.get(i)){
           if(visited[nei]==false) dfs(n,nei,h,t,c+t[nei],visited);
        }
    }
}