class Solution {
    public int maxProfit(int[] a, int fee) {
        //memoisation
        int n=a.length;
        Integer dp[][]=new Integer[n][2];
        return help(0,a,1,dp,fee);
    }
    int help(int i,int a[],int buy,Integer dp[][],int fee){
        if(i>=a.length) return 0;
        if(dp[i][buy]!=null) return dp[i][buy];
        if(buy==1){// buy
                 //buying at this index
            int b=-a[i]+help(i+1,a,0,dp,fee);//now can't buy as can have one stock at a time and transLeft will dec. on selling 
            //not buying at this index
            int nb=help(i+1,a,1,dp,fee);//can buy
            return dp[i][buy]=Math.max(b,nb);
        }else{// sell
            //selling at this index
            int s=a[i]+-fee+help(i+1,a,1,dp,fee);//now can buy and pay fee and i will inc. by 2 as cooldown 
            int ns=help(i+1,a,0,dp,fee);//not sell
            return dp[i][buy]=Math.max(s,ns);
        }
    }
}