class Solution {
    public List<List<Integer>> combinationSum(int[] a, int t) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>cur=new ArrayList<>();
        help(ans,0,t,a,cur);
        return ans;
    }
    void help(List<List<Integer>>ans,int i,int t,int a[],List<Integer>cur){
        if(i>=a.length) return;
        if(t==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        help(ans,i+1,t,a,cur);
        cur.add(a[i]);
        if(t-a[i]>=0) help(ans,i,t-a[i],a,cur);
        cur.remove(cur.size()-1);
    }
}