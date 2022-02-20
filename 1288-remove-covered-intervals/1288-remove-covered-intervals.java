class Solution {
    public int removeCoveredIntervals(int[][] a) {
         Arrays.sort(a,(x,y)->((x[0]!=y[0])?(x[0]-y[0]):(y[1]-x[1])));
        //important to sort
        int n=a.length;
        int s=a[0][0];int e=a[0][1];
        int i=0;int ans=0;
        while(i<n){
            // System.out.println(i+" "+ans);
            s=a[i][0];
            e=a[i][1];
            while(i<n&&e>=a[i][1]){
                i++;
            }
            ans++;
        }
        return ans;
    }
}