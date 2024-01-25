class Solution {
    public int longestCommonSubsequence(String a, String b) {
        //memoisation
        // Integer dp[][]=new Integer[a.length()][b.length()];
        // return help(a,b,a.length()-1,b.length()-1,dp);
        
         //tabulation with space optimisation as above only needed dp[i-1]
        int n=a.length(),m=b.length();
        int dp[]=new int[m+1];//as have to handle 0,0 in dp[j-1]
        for(int i=1;i<=n;i++){
            int prev[]=new int[m+1];
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){//as 1 based indexing
                    prev[j]=1+dp[j-1];
                }else{
                    prev[j]=Math.max(prev[j-1],dp[j]);
                }
            }
            dp=prev;
        }
        return dp[m];
        
        //tabulation
        // int n=a.length(),m=b.length();
        // int dp[][]=new int[n+1][m+1];//as have to handle 0,0 in dp[i-1][j-1]
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(a.charAt(i-1)==b.charAt(j-1)){//as 1 based indexing
        //             dp[i][j]=1+dp[i-1][j-1];
        //         }else{
        //             dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
        //         }                
        //     }
        // }
        // return dp[n][m];
        
        
    }
    
    
    //memoisation 
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