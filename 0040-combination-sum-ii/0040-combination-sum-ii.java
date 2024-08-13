class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int t) {
        Arrays.sort(a);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>c=new ArrayList<>();
        help(ans,c,t,a.length,a,0);
        return ans;
    }
    void help(List<List<Integer>>ans,List<Integer>c,int t,int n,int a[],int i){
        
        if(t<0) return;
        if(t==0) {
            ans.add(new ArrayList<>(c));
            return;
        }
        
        for(int j=i;j<n;j++){
            if((j==i)||(a[j]!=a[j-1])){
                c.add(a[j]);
                help(ans,c,t-a[j],n,a,j+1);
                c.remove(c.size()-1);
            }
        }
    }
}