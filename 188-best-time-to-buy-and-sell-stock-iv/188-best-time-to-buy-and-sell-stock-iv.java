class Solution {
    public int maxProfit(int k, int[] a) {
        //like buy and sell stock -iii  where k was 2
         int n=a.length;
        Integer dp[][][]=new Integer[n][2][k+1];
        return help(0,a,1,k,n,dp);
    }
    int help(int i,int a[],int buy,int transLeft,int n,Integer dp[][][]){
        if(transLeft==0 || i==n) return 0;
        if(dp[i][buy][transLeft]!=null) return dp[i][buy][transLeft];
        
        //buy
        if(buy==1){// buy
            //buying at this index
            int b=-a[i]+help(i+1,a,0,transLeft,n,dp);//now can't buy as can have one stock at a time and transLeft will dec. on selling 
            //not buying at this index
            int nb=0+help(i+1,a,1,transLeft,n,dp);//can buy
            return dp[i][buy][transLeft]=Math.max(b,nb);
            
        }else{// sell
            //selling at this index
            int s=a[i]+help(i+1,a,1,transLeft-1,n,dp);//now can buy and transLeft will dec. by 1 as selling 
            //not selling at this index
            int ns=0+help(i+1,a,0,transLeft,n,dp);//can't buy as not yet sold
            return dp[i][buy][transLeft]=Math.max(s,ns);
        }
    }
}