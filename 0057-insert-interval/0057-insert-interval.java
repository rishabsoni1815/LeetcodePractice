class Solution {
    public int[][] insert(int[][] a, int[] in) {
        int n=a.length;
        ArrayList<int []>ans=new ArrayList<>();
        int i=0;
        while(i<n && in[0]>a[i][1]) {
            ans.add(a[i]);
            i++;
        }
        int x[]=new int[2];
        x[0]=in[0];
        if(n>0 &&i<n) x[0]=Math.min(a[i][0],in[0]);
        int j=i;
        x[1]=in[1];
        while(j<n && a[j][0]<=in[1]) {
            x[1]=Math.max(x[1],a[j][1]);
            j++;
        }
        ans.add(x);
        while(j<n){
            ans.add(a[j]);
            j++;
        }
        int uu[][]=new int[ans.size()][2];
        for(int ii=0;ii<uu.length;ii++){
            uu[ii]=ans.get(ii);
        }
        return uu;
    }
}