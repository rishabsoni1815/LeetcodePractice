class Solution {
    public int minCostClimbingStairs(int[] a) {
        int n=a.length;
        int aa=0,b=0;
        aa=a[n-2];
        b=a[n-1];
        for(int i=n-2;i>0;i--){
            int o=aa;
            aa=a[i-1]+Math.min(aa,b);
            b=o;
        }
        return Math.min(aa,b);
    }
}