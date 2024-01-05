class Solution {
    public int lengthOfLIS(int[] a) {
        int n=a.length;
        int max=0;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(a[j]<a[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }           
            max=Math.max(dp[i],max);
        }
        return max+1;
    }
}