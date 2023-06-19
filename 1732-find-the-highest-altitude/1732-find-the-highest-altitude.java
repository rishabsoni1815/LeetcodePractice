class Solution {
    public int largestAltitude(int[] a) {
        int ans=0,max=0;
        for(int i=0;i<a.length;i++){
            ans+=a[i];
            max=Math.max(max,ans);
        }
        return max;
    }
}