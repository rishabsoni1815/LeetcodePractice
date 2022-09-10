class Solution {
   public int maxProfit(int k,int[] a) {
        int n=a.length;
        int dp[][]=new int[2][k+1];//only i+1 needed so can optimise also
        //n+1 case base case has value 0
        for(int i=n-1;i>=0;i--){
            int prev[][]=new int[2][k+1];
            for(int buy=0;buy<2;buy++){
                for(int trans=1;trans<=k;trans++){//as trans=0 is base case (value 0)
                    if(buy==1){
                        prev[buy][trans]=Math.max(-a[i]+dp[0][trans],dp[1][trans]);
                    }else{
                        prev[buy][trans]=Math.max(a[i]+dp[1][trans-1],dp[0][trans]);
                    }
                }
            }
            dp=prev;
        }
        return dp[1][k];//at 0 always buy as no choice of sell
    }
}