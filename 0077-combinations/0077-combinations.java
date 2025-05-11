class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        if(k>n) return ans;
        List<Integer>t=new ArrayList<>();
        help(n,k,ans,t);
        return ans;
    }
    void help(int n,int k,List<List<Integer>>ans,List<Integer>t){
        if(k==0) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int x=n;x>=1;x--){
            t.add(x);
            help(x-1,k-1,ans,t);
            t.remove(t.size()-1);
        }
    }
}