class Solution {
    public int minimumDifference(int[] a, int k) {
        Arrays.sort(a);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=a.length-k;i++){
            ans=Math.min(ans,a[i+k-1]-a[i]);
        }
        return ans;
    }
}