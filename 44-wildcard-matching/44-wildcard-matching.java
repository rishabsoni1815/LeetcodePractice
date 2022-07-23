class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        Boolean dp[][]=new Boolean[n][m];
        return help(n-1,m-1,s,p,dp);
    }
    boolean help(int i,int j,String s,String p,Boolean dp[][]){
        if (i < 0 && j < 0)
          return true;
        if (j < 0 && i >= 0)
          return false;
        if (i < 0 && j >= 0)
          return isAllStars(p,j);
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]=help(i-1,j-1,s,p,dp);
        }else{
            if(p.charAt(j)=='*'){
                return dp[i][j]=help(i-1,j,s,p,dp)||help(i,j-1,s,p,dp);//for a start either replace it with empty sequence (as maybe * is just extra stuff) then j-1 and i else if replace that by s.charAt(i) and do i-1 but don not do j-1 as * can replace any length of sequence of characters so can carry as it is so i-1 but j remains same 
            }else{
                return dp[i][j]=false;
            }
        }
    }
    boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
          if (S1.charAt(j) != '*')
            return false;
        }
        return true;
    }
}