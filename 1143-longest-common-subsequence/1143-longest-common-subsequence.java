class Solution {
    public int longestCommonSubsequence(String a, String b) {
        Integer dp[][]=new Integer[a.length()][b.length()];
        return help(a,b,a.length()-1,b.length()-1,dp);
    }
    int help(String a,String b,int n,int m,Integer dp[][]){
        if(n==-1 && m==-1) return 0;
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]!=null) return dp[n][m];
        if(a.charAt(n)==b.charAt(m)){
            return dp[n][m]=1+help(a,b,n-1,m-1,dp);
        }else{
            return dp[n][m]=Math.max(help(a,b,n-1,m,dp),help(a,b,n,m-1,dp));
        }
    }
}