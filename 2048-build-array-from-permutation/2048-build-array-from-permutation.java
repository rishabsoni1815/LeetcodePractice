class Solution {
    public int[] buildArray(int[] a) {
        int n=a.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=a[a[i]];
        }
        return ans;
    }
}