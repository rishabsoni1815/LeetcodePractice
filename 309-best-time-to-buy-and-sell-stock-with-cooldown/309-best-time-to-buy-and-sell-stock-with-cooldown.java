class Solution {
    public int maxProfit(int[] a) {
        int n=a.length;
        int dp[][]=new int[n+1][2];//only i+1 needed so can optimise also
        //n+1 case base case has value 0
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                    if(buy==1){
                        dp[i][buy]=Math.max(-a[i]+dp[i+1][0],dp[i+1][1]);
                    }else{
                        dp[i][buy]=Math.max((i+2<=n)?(a[i]+dp[i+2][1]):a[i],dp[i+1][0]);
                    }
            }
        }
        return dp[0][1];//at 0 always buy as no choice of sell
    }
    
    
    //memoisation
    // public int maxProfit(int[] a) {
    //     int n=a.length;
    //     Integer dp[][]=new Integer[n][2];
    //     return help(0,a,1,dp);
    // }
    // int help(int i,int a[],int buy,Integer dp[][]){
    //     if(i>=a.length) return 0;
    //     if(dp[i][buy]!=null) return dp[i][buy];
    //     if(buy==1){// buy
    //              //buying at this index
    //         int b=-a[i]+help(i+1,a,0,dp);//now can't buy as can have one stock at a time and transLeft will dec. on selling 
//             //not buying at this index
    //         int nb=help(i+1,a,1,dp);//can buy
    //         return dp[i][buy]=Math.max(b,nb);
    //     }else{// sell
//             //selling at this index
    //         int s=a[i]+help(i+2,a,1,dp);//now can buy and i will inc. by 2 as cooldown 
    //         int ns=help(i+1,a,0,dp);//not sell
    //         return dp[i][buy]=Math.max(s,ns);
    //     }
    // }
}