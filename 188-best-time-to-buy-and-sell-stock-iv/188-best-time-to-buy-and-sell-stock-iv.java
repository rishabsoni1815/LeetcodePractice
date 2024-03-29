class Solution {
    //space optimised dp tabulation
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
    
    //tabulation
/*
public int maxProfit(int k,int[] a) {
        int n=a.length;
        int dp[][][]=new int[n+1][2][k+1];//only i+1 needed so can optimise also
        //n+1 case base case has value 0
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int trans=1;trans<=k;trans++){//as trans=0 is base case (value 0)
                    if(buy==1){
                        dp[i][buy][trans]=Math.max(-a[i]+dp[i+1][0][trans],dp[i+1][1][trans]);
                    }else{
                        dp[i][buy][trans]=Math.max(a[i]+dp[i+1][1][trans-1],dp[i+1][0][trans]);
                    }
                }
            }
        }
        return dp[0][1][k];//at 0 always buy as no choice of sell
    }
    */
    
    //memoisation
//     public int maxProfit(int k, int[] a) {
//         //like buy and sell stock -iii  where k was 2
//          int n=a.length;
//         Integer dp[][][]=new Integer[n][2][k+1];
//         return help(0,a,1,k,n,dp);
//     }
//     int help(int i,int a[],int buy,int transLeft,int n,Integer dp[][][]){
//         if(transLeft==0 || i==n) return 0;
//         if(dp[i][buy][transLeft]!=null) return dp[i][buy][transLeft];
        
//         //buy
//         if(buy==1){// buy
//             //buying at this index
//             int b=-a[i]+help(i+1,a,0,transLeft,n,dp);//now can't buy as can have one stock at a time and transLeft will dec. on selling 
//             //not buying at this index
//             int nb=0+help(i+1,a,1,transLeft,n,dp);//can buy
//             return dp[i][buy][transLeft]=Math.max(b,nb);
            
//         }else{// sell
//             //selling at this index
//             int s=a[i]+help(i+1,a,1,transLeft-1,n,dp);//now can buy and transLeft will dec. by 1 as selling 
//             //not selling at this index
//             int ns=0+help(i+1,a,0,transLeft,n,dp);//can't buy as not yet sold
//             return dp[i][buy][transLeft]=Math.max(s,ns);
//         }
//     }
}
