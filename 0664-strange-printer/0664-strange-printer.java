class Solution {
    public int strangePrinter(String s) {
        //other sol. in submissions
        int n=s.length();
        Integer dp[][]=new Integer[n][n];
        return help(0,n-1,n,s,dp);
    }
    int help(int i,int j,int n,String s,Integer dp[][]){
        if(i==j) return 1;
        //matrix chain multiplication
        if(dp[i][j]!=null) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            min=Math.min(min,help(i,k,n,s,dp)+help(k+1,j,n,s,dp));
        }
        if(s.charAt(i)==s.charAt(j)) min--;
        return dp[i][j]=min;
    }
}