class Solution {
    public double average(int[] a) {
        int n=a.length;
        int max=a[0],min=a[0];
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            max=Math.max(max,a[i]);
            min=Math.min(min,a[i]);
        }
        return (double)(sum-max-min)/(n-2);
    }
}