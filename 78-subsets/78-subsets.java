class Solution {
    public List<List<Integer>> subsets(int[] a) {
        int n=a.length;
        List<List<Integer>>ans=new ArrayList<>();
         List<Integer>t=new ArrayList<Integer>();
        h(a,0,n,ans,t);
        return ans;
    }
     void h(int a[],int i,int n,List<List<Integer>>ans,List<Integer>t){
        if(i>=n){
            ans.add(new ArrayList<>(t));
            return;
        }//pick and non pick
        t.add(a[i]);
        h(a,i+1,n,ans,t);
        t.remove(t.size()-1);
        h(a,i+1,n,ans,t);
    }
}