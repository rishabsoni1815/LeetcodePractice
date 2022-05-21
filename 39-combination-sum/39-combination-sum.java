class Solution {
    public List<List<Integer>> combinationSum(int[] a, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>t=new ArrayList<>();
        help(ans,t,0,k,a);
        return ans;
    }
    void help(List<List<Integer>>ans,List<Integer>t,int i,int sum,int a[]){
        if(sum==0){
            ans.add(new ArrayList<>(t));
            return;
        }
        if(sum<0 || i>=a.length) return;
        
        t.add(a[i]);
        help(ans,t,i,sum-a[i],a);
        t.remove(t.size()-1);
        help(ans,t,i+1,sum,a);
    }
}