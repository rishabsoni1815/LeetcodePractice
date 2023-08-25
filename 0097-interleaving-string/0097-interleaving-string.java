class Solution {
    public boolean isInterleave(String a, String b, String c) {
        int n=a.length(),m=b.length(),l=c.length();
        Boolean dp[][]=new Boolean[n+1][m+1];
        return help(a,b,c,n,m,l,0,0,0,dp);
    }
    boolean help(String a,String b,String c,int n,int m,int l,int i,int j,int k,Boolean dp[][]){
        if(k>=l && i>=n && j>=m) return true;
        if(k>=l) return false;
        if(dp[i][j]!=null) return dp[i][j];
        boolean ans=false;
        if(i<n && a.charAt(i)==c.charAt(k)) ans|=help(a,b,c,n,m,l,i+1,j,k+1,dp);
        if(j<m && b.charAt(j)==c.charAt(k)) ans|=help(a,b,c,n,m,l,i,j+1,k+1,dp);
        return dp[i][j]=ans;
    }
}