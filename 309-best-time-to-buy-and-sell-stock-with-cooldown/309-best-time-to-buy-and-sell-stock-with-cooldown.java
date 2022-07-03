class Solution {
    public int maxProfit(int[] a) {
        int n=a.length;
        Integer dp[][]=new Integer[n][2];
        return help(0,a,1,dp);
    }
    int help(int i,int a[],int buy,Integer dp[][]){
        if(i>=a.length) return 0;
        if(dp[i][buy]!=null) return dp[i][buy];
        if(buy==1){
            int b=-a[i]+help(i+1,a,0,dp);
            int nb=help(i+1,a,1,dp);
            return dp[i][buy]=Math.max(b,nb);
        }else{
            int s=a[i]+help(i+2,a,1,dp);
            int ns=help(i+1,a,0,dp);
            return dp[i][buy]=Math.max(s,ns);
        }
    }
}