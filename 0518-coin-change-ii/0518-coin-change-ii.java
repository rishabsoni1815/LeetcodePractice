class Solution {
   public int change(int t, int[] a) {
         int n=a.length;
        int dp[]=new int[t+1];
        for(int i=1;i<=n;i++){
            int prev[]=new int[t+1];
            prev[0]=1;
            for(int j=1;j<=t;j++){
                int nt=dp[j];
                int ta=0;
                if(j-a[i-1]>=0) ta=prev[j-a[i-1]];
                prev[j]=ta+nt;
            }
            dp=prev;
        }
        return dp[t];
    }
    
    
    
        //can optimise as i-1 only required
 //   public int change(int t, int[] a) {
//          int n=a.length;
//         int dp[][]=new int[n+1][t+1];
//         for(int i=0;i<=n;i++) dp[i][0]=1;
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=t;j++){
//                 int nt=dp[i-1][j];
//                 int ta=0;
//                 if(j-a[i-1]>=0) ta=dp[i][j-a[i-1]];
//                 dp[i][j]=ta+nt;
//             }
//         }
//         return dp[n][t];
//     }
    
    
    
    /*
    //memoisation
    static long help(int i,int t,int a[],Long dp[][]){
        if(t==0) return 1L;
        if(i<0 || t<0) return 0L;
       if(dp[i][t]!=null) return dp[i][t];
        return dp[i][t]=help(i,t-a[i],a,dp)+help(i-1,t,a,dp);
    }
    
    */
}