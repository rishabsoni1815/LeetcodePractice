class Solution {
    public long maxSubarraySum(int[] a, int k) {
        int n=a.length;
        long dp[]=new long[n];
        long sum[]=new long[n];
        for(int i=0;i<n;i++){
            sum[i]=(long)a[i];
            if(i-1>=0) sum[i]+=sum[i-1];
        }
        long max=Long.MIN_VALUE;
        for(int i=k-1;i<n;i++){
            long csum = sum[i];
            if(i-k>=0) csum-=sum[i-k];
            if(i-k>=0){
                dp[i]=Math.max(csum+dp[i-k],csum);
            }else{
                dp[i]=csum;
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}