class Solution {
    public int[] gardenNoAdj(int n, int[][] a) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<a.length;i++){
            g.get(a[i][0]-1).add(a[i][1]-1);
            g.get(a[i][1]-1).add(a[i][0]-1);
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(ans[i]==0) {
                ans[i]=1;
                help(i,g,n,ans);
            }
        }
        return ans;
    }
    void help(int i,ArrayList<ArrayList<Integer>>g,int n,int ans[]){
        for(int nei:g.get(i)){
            for(int j=1;j<=4;j++){
                if(ans[nei]==0 && safe(nei,ans,g,j)) {
                    ans[nei]=j;
                    help(nei,g,n,ans);
                }
            }
        }
    }
    boolean safe(int i,int ans[],ArrayList<ArrayList<Integer>>g,int j){
        for(int nei:g.get(i)){
            if(ans[nei]==j) return false;
        }
        return true;
    }
}