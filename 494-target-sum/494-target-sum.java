class Solution {
    public int findTargetSumWays(int[] a, int t) {
        /*
        
        like count of subsets with given sum ->
            S1 - S2 = target
    S1 + S2 = sum of all the elements   

    By simplifing the above 2 equations we get, 2* S1 = target + Sum of all the elements

    => S1 = (target + Sum of all the elements) / 2
        
        */
        int sum=0;
        for(int x:a) sum+=x;
        if((Math.abs(t)>sum)||(t+sum)%2!=0) return 0;
        t=(t+sum)/2;
        int n=a.length;
        int dp[][]=new int[n+1][t+1];
        dp[0][0]=1;
        // for(int i=0;i<=n;i++) dp[i][0]=1; not doing this as we do in target sum as array can have 0 so if sum==0 it is not always true we have to consider choices ( to include 0 or not)
        for(int i=1;i<=n;i++){
            for(int j=0;j<=t;j++){
                dp[i][j]=dp[i-1][j];
                if(j-a[i-1]>=0) dp[i][j]+=dp[i-1][j-a[i-1]];
            }
        }
        return dp[n][t];
    }
}