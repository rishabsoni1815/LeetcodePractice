class Solution {
    public List<List<Integer>> subsetsWithDup(int[] a) {
         Arrays.sort(a);
         List<List<Integer>>ans=new ArrayList<>();
         List<Integer>t=new ArrayList<>();
         help(ans,t,0,a);
         return ans;
    }
    void help(List<List<Integer>>ans,List<Integer>t,int i,int a[]){
        ans.add(new ArrayList<>(t));
        for(int j=i;j<a.length;j++){//taking next as only one of all 2's present 
            if(j==i || (a[j]!=a[j-1])){
                t.add(a[j]);
                help(ans,t,j+1,a);
                t.remove(t.size()-1);
            }
        }
    }
}