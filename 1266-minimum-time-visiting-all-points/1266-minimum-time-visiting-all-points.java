class Solution {
    public int minTimeToVisitAllPoints(int[][] a) {
        int ans=0;
        for(int i=1;i<a.length;i++){
            int dx=(int)Math.abs(a[i][0]-a[i-1][0]);
            int dy=(int)Math.abs(a[i][1]-a[i-1][1]);
            int max=Math.max(dx,dy);
            ans+=max;
        }
        return ans;
    }
}