class Solution {
    public int change(int t, int[] a) {
          int n=a.length;
        int dp[]=new int[t+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int prev[]=new int[t+1];
            prev[0]=1;
            for(int j=1;j<=t;j++){
                prev[j]=dp[j];
                if(j-a[i-1]>=0) prev[j]+=prev[j-a[i-1]];
            }
            dp=prev;
        }
        return dp[t];
    }
}