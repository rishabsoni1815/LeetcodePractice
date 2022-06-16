class Solution {
    public String longestPalindrome(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        String ans="";
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                } else if(g == 1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }

                if(dp[i][j]){
                    //System.out.println(i+" "+j);
                     String t="";
                  if(i<=j) t=str.substring(i,j+1);
                    //System.out.println(t);
                    if(t.length()>ans.length()) ans=t;
                }
            }
        }
            return ans;
    }
}