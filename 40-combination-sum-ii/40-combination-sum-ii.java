class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>t=new ArrayList<>();
        f(ans,t,candidates,0,target);
        return ans;
    }
   void f(List<List<Integer>>ans,List<Integer>t,int a[],int j,int s){
        if(s==0){
           ans.add(new ArrayList<>(t));
            return;
        }else if(s<0) return ;
        for(int i=j;i<a.length;i++){
            if(i!=j&&a[i]==a[i-1]) continue;
              t.add(a[i]);
              f(ans,t,a,i+1,s-a[i]);
              t.remove(t.size()-1);
          }
           // f(ans,t,a,i+1,s);///not doing as in for loop we are checking every possibility // see subsetsII question and tuf video
        }
}