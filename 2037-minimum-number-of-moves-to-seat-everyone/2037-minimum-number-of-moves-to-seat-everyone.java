class Solution {
    public int minMovesToSeat(int[] a, int[] s) {
        int n=a.length,ans=0;
        Arrays.sort(a);
        Arrays.sort(s);
        for(int i=0;i<n;i++){
            ans+=Math.abs(a[i]-s[i]);
        }
        return ans;
    }
}