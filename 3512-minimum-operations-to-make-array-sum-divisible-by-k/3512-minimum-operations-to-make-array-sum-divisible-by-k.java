class Solution {
    public int minOperations(int[] a, int k) {
        int ans=0;
        for(int i=0;i<a.length;i++){
            ans+=a[i];
        }
        return ans%k;
    }
}