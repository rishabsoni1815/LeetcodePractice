class Solution {
    public int minTimeToVisitAllPoints(int[][] a) {
        int ans=0,n=a.length;
        for(int i=1;i<n;i++){
            int px=a[i-1][0];
            int py=a[i-1][1];
            int x=Math.abs(px-a[i][0]),y=Math.abs(py-a[i][1]);
            ans+=Math.max(x,y);
        }
        return ans;
    }
}