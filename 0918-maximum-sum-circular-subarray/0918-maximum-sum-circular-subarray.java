class Solution {
    public int maxSubarraySumCircular(int[] a) {
        int n=a.length;
        int max=Integer.MIN_VALUE,sum=0,ts=0;
        for(int i=0;i<n;i++){
            ts+=a[i];
            sum+=a[i];
            max=Math.max(max,sum);
            if(sum<=0){
                sum=0;
            }
        }
        if(max<0) return max;
        int min=Integer.MAX_VALUE;sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            min=Math.min(min,sum);
            if(sum>=0){
                sum=0;
            }
        }
        // System.out.println(max+" "+min+" "+ts);
        return Math.max(max,ts-min);
    }
}