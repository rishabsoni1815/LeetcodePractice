class Solution {
    //backtracking
    // public List<List<Integer>> subsets(int[] a) {
    //     int n=a.length;
    //     List<List<Integer>>ans=new ArrayList<>();
    //     List<Integer>t=new ArrayList<>();
    //     help(ans,t,0,a);
    //     return ans;
    // }
    // void help(List<List<Integer>>ans,List<Integer>t,int i,int a[]){
    //     if(i>=a.length){
    //         ans.add(new ArrayList<>(t));
    //         return;
    //     }
    //     t.add(a[i]);
    //     help(ans,t,i+1,a);
    //     t.remove(t.size()-1);
    //     help(ans,t,i+1,a);
    // }
    
    //bits
    public List<List<Integer>> subsets(int[] a) {
        int n=a.length;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<(Math.pow(2,n));i++){
            List<Integer>t=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(((1<<j)&i)>0){
                    t.add(a[j]);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}