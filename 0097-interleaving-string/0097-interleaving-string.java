class Solution {
    public boolean isInterleave(String a, String b, String c) {
        int n=a.length(),m=b.length(),l=c.length();
        //i+1 or i-1 only so can space optimise
        if(n+m!=l) return false;
        boolean dp[][]=new boolean[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    if(i==0 && j==0){
                        dp[i][j]=true;   
                    }else if(i==0){
                        if(b.charAt(j-1)==c.charAt(i+j-1)) dp[i][j]=dp[i][j-1];
                    }else{
                        if(a.charAt(i-1)==c.charAt(i+j-1)) dp[i][j]=dp[i-1][j];
                    }
                }
                if(i>0 && a.charAt(i-1)==c.charAt(i+j-1)){
                    dp[i][j]|=dp[i-1][j];
                }
                if(j>0 && b.charAt(j-1)==c.charAt(i+j-1)){
                    dp[i][j]|=dp[i][j-1];
                }
            }
        }
        return dp[n][m];
        
        
        // Boolean dp[][]=new Boolean[n+1][m+1];
        // return help(a,b,c,n,m,l,0,0,dp);
    }
    boolean help(String a,String b,String c,int n,int m,int l,int i,int j,Boolean dp[][]){
        if((i+j)>=l && i>=n && j>=m) return true;
        if((i+j)>=l) return false;
        if(dp[i][j]!=null) return dp[i][j];
        boolean ans=false;
        if(i<n && a.charAt(i)==c.charAt(i+j)) ans|=help(a,b,c,n,m,l,i+1,j,dp);
        if(j<m && b.charAt(j)==c.charAt(i+j)) ans|=help(a,b,c,n,m,l,i,j+1,dp);
        return dp[i][j]=ans;
    }
}