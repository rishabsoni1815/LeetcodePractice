class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        Integer dp[][]=new Integer[n][n];
        
        return help(0,n-1,s,dp);
    }
    int help(int i,int j,String s,Integer dp[][]){
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
         if(s.charAt(i)==s.charAt(j)){
           return dp[i][j]=2+help(i+1,j-1,s,dp);
         }
         return dp[i][j]=Math.max(help(i+1,j,s,dp),help(i,j-1,s,dp));
    }
}