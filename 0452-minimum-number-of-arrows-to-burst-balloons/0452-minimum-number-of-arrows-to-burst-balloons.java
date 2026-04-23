class Solution {
    public int findMinArrowShots(int[][] a) {
        Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));
        int i=0,n=a.length,ans=0,end=0;
        while(i<n){
            ans++;
            end=a[i][1];
            while(i+1<n && end>=a[i+1][0]){
                end=Math.min(end,a[i+1][1]);
                i++;
            }
            i++;
        }
        return ans;
    }
}