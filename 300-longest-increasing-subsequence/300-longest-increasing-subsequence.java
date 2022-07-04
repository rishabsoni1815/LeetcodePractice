class Solution {
    public int lengthOfLIS(int[] a) {
        //o(n^2) tabulation
        int n=a.length;
        int max=1;//as n>=1
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(a[j]<a[i]) {
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}


//memoisation o(n^2)
// class Solution {
//     int ans=0;
//     public int lengthOfLIS(int[] a) {
//         ans=1;
//         int n=a.length;
//         Integer dp[]=new Integer[n];
//         help(n-1,a,dp);
//         return ans;
//     }
//     int help(int i,int a[],Integer dp[]){
//         if(i==0) return 1;
//         int max=1;
//         if(dp[i]!=null) return dp[i];
//         for(int j=0;j<i;j++){
//             int res=help(j,a,dp);//note have to call for all as we want to check all lis ending at all indces and get max of them
//             if(a[j]<a[i]){
//                 max=Math.max(max,1+res);
//             }
//         }
//         ans=Math.max(ans,max);
//         return dp[i]=max;
//     }
// }