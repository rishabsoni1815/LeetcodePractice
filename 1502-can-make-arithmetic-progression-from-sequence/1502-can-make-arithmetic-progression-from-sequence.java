class Solution {
    public boolean canMakeArithmeticProgression(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        int x=a[1]-a[0];
        for(int i=2;i<n;i++){
            if((a[i]-a[i-1])!=x) return false;
        }
        return true;
    }
}