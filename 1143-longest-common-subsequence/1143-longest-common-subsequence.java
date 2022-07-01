class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n=s.length(),m=t.length();
        int dp[]=new int[m+1];
        for(int i=1;i<=n;i++){
            int prev[]=new int[m+1];
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                   prev[j]=1+dp[j-1];
               }else{
                  prev[j]=Math.max(dp[j],prev[j-1]);
               }
            }
            dp=prev;
        }
       return dp[m];
    }
    /*
    only i-1 so optimise
    public static int lcs(String s, String t) {
		int n=s.length(),m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                   dp[i][j]=1+dp[i-1][j-1];
               }else{
                  dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
            }
        }
       return dp[n][m];
    }
    
    
    */
   static int help(int i,int j,String s,String t,Integer dp[][]){
       if(i<0||j<0) return 0;
       if(dp[i][j]!=null) return dp[i][j];
       if(s.charAt(i)==t.charAt(j)){
           return dp[i][j]=1+help(i-1,j-1,s,t,dp);
       }else{
           return dp[i][j]=Math.max(help(i-1,j,s,t,dp),help(i,j-1,s,t,dp));
       }
   }
}