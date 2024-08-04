class Solution {
    public int maxProfit(int[] a, int fee) {
        int n=a.length;
        int dp[]=new int[2];
        //n+1 case base case has value 0
        for(int i=n-1;i>=0;i--){
            int prev[]=new int[2];
            for(int buy=0;buy<2;buy++){
                    if(buy==1){
                        prev[buy]=Math.max(-a[i]+dp[0],dp[1]);
                    }else{
                        prev[buy]=Math.max(a[i]-fee+dp[1],dp[0]);
                    }
            }
            dp=prev;
        }
        return dp[1];//at 0 always buy as no choice of sell
    }
    
    
    
    // //i+1 so can do space optimise 
    // public int maxProfit(int[] a, int fee) {
    //     int n=a.length;
    //     int dp[][]=new int[n+1][2];
    //     //n+1 case base case has value 0
    //     for(int i=n-1;i>=0;i--){
    //         for(int buy=0;buy<2;buy++){
    //                 if(buy==1){
    //                     dp[i][buy]=Math.max(-a[i]+dp[i+1][0],dp[i+1][1]);
    //                 }else{
    //                     dp[i][buy]=Math.max(a[i]-fee+dp[i+1][1],dp[i+1][0]);
    //                 }
    //         }
    //     }
    //     return dp[0][1];//at 0 always buy as no choice of sell
    // }
    
    // public int maxProfit(int[] a, int fee) {
    //     //memoisation
    //     int n=a.length;
    //     Integer dp[][]=new Integer[n][2];
    //     return help(0,a,1,dp,fee);
    // }
    // int help(int i,int a[],int buy,Integer dp[][],int fee){
    //     if(i>=a.length) return 0;
    //     if(dp[i][buy]!=null) return dp[i][buy];
    //     if(buy==1){// buy
    //              //buying at this index
    //         int b=-a[i]+help(i+1,a,0,dp,fee);//now can't buy as can have one stock at a time and transLeft will dec. on selling 
    //         //not buying at this index
    //         int nb=help(i+1,a,1,dp,fee);//can buy
    //         return dp[i][buy]=Math.max(b,nb);
    //     }else{// sell
    //         //selling at this index
    //         int s=a[i]-fee+help(i+1,a,1,dp,fee);//now can buy and pay fee and i will inc. by 1 
    //         int ns=help(i+1,a,0,dp,fee);//not sell
    //         return dp[i][buy]=Math.max(s,ns);
    //     }
    // }
}