class Solution {
//     public int uniquePaths(int m, int n) {
//         int dp[][]=new int[m+1][n+1];
//         for(int i=m;i>0;i--){
//             for(int j=n;j>0;j--){
//                 if(j==n||i==m){
//                     dp[i][j]=1;
//                 }else{
//                     dp[i][j]=dp[i+1][j]+dp[i][j+1];
//                 }
//             }
//         }
//         return dp[1][1];
//     }
    
    
    
    
    // as only i+1 required so can optimise
    public int uniquePaths(int m, int n) {
        int dp[]=new int[n+1];
        for(int i=m;i>0;i--){
            int prev[]=dp;
            for(int j=n;j>0;j--){
                if(j==n||i==m){
                    prev[j]=1;
                }else{
                    prev[j]=dp[j]+prev[j+1];
                }
            }
            dp=prev;
        }
        return dp[1];
    }
    
    
    
    /*
     or as total down we have to take is m-1 (m is the no. of rows here) and as total right we have to take is n-1 (n is the no. of colm. here) which total is m-1+n-1= m+n-2 the answer can be (m+n-2) C (n-1) or (m+n-2) C (m-1) as out of m+n-2 directions i have to fix either n-1 then m-1 will make combinations or fix m-1 and n-1 will make diff combos , so (m+n-2) C (n-1) or (m+n-2) C (m-1)
     
     code--->
      public int uniquePaths(int m, int n) {
        int N=m+n-2;
        int r=m-1;
        double res=1;
        for(int i=1;i<=r;i++){
            res=res*(N-r+i)/i;// N-r+i as 10 C 3 =(8*9*10)/(1*2*3) so numerator is backwards not 8*9*10 so N-r+i -> for i=1 N-r=7 , 7+1=8 then 7+2=9, and so on
        }
        return (int)(res);
    }
     
    */
}