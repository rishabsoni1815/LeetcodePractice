class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        if(k>n) return ans;
        List<Integer>t=new ArrayList<>();
        help(n,k,ans,t);
        return ans;
    }
    void help(int n,int k,List<List<Integer>>ans,List<Integer>t){
        if(k==0){
            ans.add(new ArrayList<>(t));
            return;
        }
        if(n<=0) return;
        t.add(n);
        help(n-1,k-1,ans,t);
        t.remove(t.size()-1);
        help(n-1,k,ans,t);
    }
}