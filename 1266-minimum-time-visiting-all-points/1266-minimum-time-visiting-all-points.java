class Solution {
    public int minTimeToVisitAllPoints(int[][] a) {
        int ans=0;
        for(int i=1;i<a.length;i++){
            int dx=(int)Math.abs(a[i][0]-a[i-1][0]);
            int dy=(int)Math.abs(a[i][1]-a[i-1][1]);
            int min=Math.min(dx,dy);
            ans+=min;
            if(dx>dy){
                ans+=(dx-min);
            }else if(dx<dy){
                ans+=(dy-min);
            }
        }
        return ans;
    }
}