class Solution {
    public int eraseOverlapIntervals(int[][] a) {
        int n=a.length;
        int ans=0,i=0,end=0;
        Arrays.sort(a,(x,y)->(x[0]!=y[0])? Integer.compare(x[0],y[0]):Integer.compare(x[1],y[1]));
        while(i<n){
            end=a[i][1];
            while(i+1<n && end>a[i+1][0]){
                end=Math.min(end,a[i+1][1]);//when two intervals overlap and you are forced to remove one, always remove the interval that ends later. You want to keep the one that ends as early as possible.
                i++;
                ans++;
            }
            i++;
        }
        return ans;
    }
}