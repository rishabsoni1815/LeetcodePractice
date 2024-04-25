class Solution {
    public int longestIdealString(String s, int k) {
        //o(n*26) -> dp[i][k] will check how much max len is possible till i having kas the char at i
        int n=s.length();
        int dp[][]=new int[n][26];
        dp[0][s.charAt(0)-'a']=1;
        int ans=1;
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=1;i<n;i++){
            int x=s.charAt(i)-'a';
            dp[i][x]=1;
            for(int j=Math.max(0,x-k);j<=(Math.min(25,x+k));j++){
                dp[i][x]=Math.max(dp[i][x],1+dp[i-1][j]);
            }
            for(int j=0;j<26;j++){
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                if(i==n-1) ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }    
    
    // o(n^2)
    // public int longestIdealString(String s, int k) {
    //     int n=s.length();
    //     int dp[]=new int[n];
    //     dp[0]=1;
    //     int ans=1;
    //     for(int i=1;i<n;i++){
    //         dp[i]=1;
    //         for(int j=0;j<i;j++){
    //             if(Math.abs(s.charAt(i)-s.charAt(j)) <=k){
    //                 dp[i]=Math.max(dp[i],1+dp[j]);
    //             }
    //         }
    //         ans=Math.max(ans,dp[i]);
    //     }
    //     return ans;
    // }
}