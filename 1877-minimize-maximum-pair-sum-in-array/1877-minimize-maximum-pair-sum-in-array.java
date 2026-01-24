class Solution {
    public int minPairSum(int[] a) {
        Arrays.sort(a);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<a.length/2;i++){
            ans=Math.max(ans,a[i]+a[a.length-i-1]);
        }
        return ans;
    }
}
