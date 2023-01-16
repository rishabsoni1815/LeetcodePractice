class Solution {
    public int[][] insert(int[][] a, int[] b) {
        List<int []>ans=new ArrayList<>();
        int i=b[0];
        int j=b[1];
        int c=0;
        while(c<a.length&&a[c][1]<i){
            ans.add(a[c]);
            c++;
        }
        while(c<a.length&&a[c][0]<=j){
            i=Math.min(i,a[c][0]);
            j=Math.max(j,a[c][1]);
            c++;
        }
        ans.add(new int[]{i,j});
        while(c<a.length){
              ans.add(a[c]);
            c++;
        }
       int u[][]=new int[ans.size()][];
        u=ans.toArray(u);
         return u; 
    }
}