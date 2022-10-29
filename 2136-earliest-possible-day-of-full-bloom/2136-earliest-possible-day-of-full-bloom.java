class Solution {
    public int earliestFullBloom(int[] a, int[] b) {
        int n=a.length;
        ArrayList<int []>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new int[]{b[i],a[i]});
        Collections.sort(g,(x,y)->((x[0]==y[0]?(x[1]-y[1]):(x[0]-y[0]))));
        int res=0;
        for(int x[]:g){
            res=Math.max(res,x[0])+x[1];
        }
        return res;
    }
}