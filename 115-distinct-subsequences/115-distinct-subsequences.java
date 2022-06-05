class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        help(s,t,0,0,dp);
        return dp[0][0];
    }
    int help(String s,String t,int i,int j,int dp[][]){
        if(j==t.length()){
            return 1;
        }
        if(i>=s.length()||j>=t.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int x=0;
        if(s.charAt(i)==t.charAt(j)){
            x+=help(s,t,i+1,j+1,dp);
        }
            x+=help(s,t,i+1,j,dp);
        return dp[i][j]=x;
    }
}