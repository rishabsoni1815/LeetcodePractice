class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>b=new ArrayList<>();
        f(ans,b,nums,0);
        return ans;
    }
    void f(List<List<Integer>>ans,List<Integer>t,int a[],int j){
        ans.add(new ArrayList<>(t));
        for(int i=j;i<a.length;i++){
            if(i!=j&&a[i]==a[i-1]){
                continue;
            }
            t.add(a[i]);
            f(ans,t,a,i+1);
            t.remove(t.size()-1);
        }
        
    }
}