class Solution {
    public int minDistance(String s, String t) {
        int n=s.length();int m=t.length();       
        int dp[]=new int[m+1];
        for(int i=0;i<=m;i++) dp[i]=i;
        for(int i=1;i<=n;i++){
            int prev[]=new int[m+1];
            for(int j=0;j<=m;j++){
                if(j==0){
                    prev[j]=i;
                    continue;
                }
                if(s.charAt(i-1)==t.charAt(j-1)){
                    prev[j]=dp[j-1];
                }else{
                    prev[j]=1+Math.min(dp[j],prev[j-1]);
                }
            }
            dp=prev;
        }
        return dp[m];
    }
    /*
    
    i-1 so can optimise
    public static int minDistance(String s, String t) {
        int n=s.length();int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=m;i++) dp[0][i]=i;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j==0){
                    dp[i][j]=i;
                    continue;
                }
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    */
    static int help(int i,int j,String s,String t){
        if(i==-1 && j==-1) return 0;
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(s.charAt(i)==t.charAt(j)){
            return help(i-1,j-1,s,t);
        }else{
            return 1+Math.min(help(i-1,j,s,t),help(i,j-1,s,t));
        }
    }
}