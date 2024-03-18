class Solution {
    public int findMinArrowShots(int[][] a) {
        int n=a.length;
        Arrays.sort(a,(x,y)->(x[0]!=y[0] ? Integer.compare(x[0],y[0]):Integer.compare(x[1],y[1])));//not using x[0]-y[0] as this can be out of bount in case of int_min so use Integer.compare as this internally does not subtracts to compare rather directly compares so does not return in overflow
        int e=a[0][1],ans=0;
        for(int i=0;i<n;){
            e=a[i][1];
            i++;
            while(i<n && e>=a[i][0]){
                e=Math.min(e,a[i][1]);//imp as end of next to a[i] maybe less
                i++;
            }
            ans++;
        }
        return ans;
    }
}