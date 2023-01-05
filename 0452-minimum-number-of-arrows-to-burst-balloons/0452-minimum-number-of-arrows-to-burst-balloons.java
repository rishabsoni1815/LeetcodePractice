class Solution {
    public int findMinArrowShots(int[][] a) {
        int n=a.length; 
        Arrays.sort(a,(x,y)->(x[0]==y[0])?(Integer.compare(x[1], y[1])):(Integer.compare(x[0], y[0])));
        int ans=0,i=0,s=a[0][0],e=a[0][1];
        while(i<n){
            ans++;
            s=a[i][0];
            e=a[i][1];
            while(i+1<n && a[i+1][0]<=e){
                e=Math.min(a[i+1][1],e);
                i++;
            }
            i++;
        }
        return ans;
    }
}