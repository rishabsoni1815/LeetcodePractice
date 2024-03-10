class Solution {
    public int[] intersection(int[] a, int[] b) {
        int n=a.length,m=b.length;
        ArrayList<Integer>ans=new ArrayList<>();
        HashSet<Integer>res=new HashSet<>();
        for(int i=0;i<n;i++){
            res.add(a[i]);
        }
        for(int i=0;i<m;i++){
            if(res.contains(b[i])){
                ans.add(b[i]);
                res.remove(b[i]);
            }
        }
        int y[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            y[i]=ans.get(i);
        }
        return y;
    }
}