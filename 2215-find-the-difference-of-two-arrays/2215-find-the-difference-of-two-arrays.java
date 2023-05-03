class Solution {
    public List<List<Integer>> findDifference(int[] a, int[] b) {
        int n=a.length;int m=b.length;
     HashSet<Integer>h1=new HashSet<Integer>();
        for(int i=0;i<n;i++)h1.add(a[i]);
     HashSet<Integer>h2=new HashSet<Integer>();
        for(int i=0;i<m;i++)h2.add(b[i]);
        HashSet<Integer>ans1=new HashSet<>();
        HashSet<Integer>ans2=new HashSet<>();
        for(int i=0;i<n;i++){
            if(h2.contains(a[i])==false){
                ans1.add(a[i]);
            }
        }
        for(int i=0;i<m;i++){
            if(h1.contains(b[i])==false){
                ans2.add(b[i]);
            }
        }
        
        ArrayList<Integer>ans11=new ArrayList<>();
        ArrayList<Integer>ans22=new ArrayList<>();
        for(int i:ans1)ans11.add(i);
        for(int i:ans2)ans22.add(i);
        List<List<Integer>>ans=new ArrayList<>();
        ans.add(ans11);
        ans.add(ans22);
        return ans;
    }
}