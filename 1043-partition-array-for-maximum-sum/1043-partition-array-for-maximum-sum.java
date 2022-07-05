class Solution {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int n=a.length;
        Integer dp[]=new Integer[n];
        return help(0,a,k,dp);
    }
    int help(int i,int a[],int k,Integer dp[]){
       if(i==a.length) return 0;
        int len=0;
        if(dp[i]!=null) return dp[i];
        int max=Integer.MIN_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(a.length,i+k);j++){
            len++;
            maxi=Math.max(maxi,a[j]);
            max=Math.max(max,len*maxi+help(j+1,a,k,dp));
        }
        return dp[i]=max;
    }
}