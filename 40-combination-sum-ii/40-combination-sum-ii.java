class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>t=new ArrayList<>();
        Arrays.sort(a);
        help(ans,t,0,k,a);
        return ans;
    }
   void help(List<List<Integer>>ans,List<Integer>t,int i,int sum,int a[]){
        if(sum==0) {
            ans.add(new ArrayList<>(t));
        }
       if(sum<0) return;
        for(int j=i;j<a.length;j++){
            if(j==i || (a[j]!=a[j-1])){
                t.add(a[j]);
                help(ans,t,j+1,sum-a[j],a);
                t.remove(t.size()-1);
            }
        }
    }
}