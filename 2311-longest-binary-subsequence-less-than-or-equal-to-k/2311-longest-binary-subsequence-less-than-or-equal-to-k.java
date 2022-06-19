class Solution {
    public int longestSubsequence(String s, int k) {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return help(s,k,n-1,dp,0);
    }
    int help(String s,int sum,int i,int dp[][],int l){
        if(i<0){
            return 0;
        }
        char c=s.charAt(i);
        if(dp[i][l]!=-1) return dp[i][l];
        int nt=help(s,sum,i-1,dp,l);
        int t=0;
       if((sum-(c-'0')*(int)Math.pow(2,l)) >=0) t=help(s,sum-(c-'0')*(int)Math.pow(2,l),i-1,dp,l+1)+1;
        
        return dp[i][l]=Math.max(t,nt);
    }
}