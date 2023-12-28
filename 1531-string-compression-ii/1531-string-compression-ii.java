class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
       Integer dp[][][][] = new Integer[s.length()+1][k+1][27][101];
        return dfs(s, k, 0, (char) ('a'+26), 0, dp);
    }
    
    
    private int dfs(String s, int k, int i, char prevChar, int prevFreq, Integer dp[][][][]) {
              
        if(k<0) return Integer.MAX_VALUE;
        
        if(i==s.length()) return 0;       
        
         if(dp[i][k][prevChar-'a'][prevFreq]!=null) return dp[i][k][prevChar-'a'][prevFreq];
        
        
        
        int delete = Integer.MAX_VALUE;
        int dontDelete = Integer.MAX_VALUE;
        
        
        delete = dfs(s, k-1, i+1, prevChar, prevFreq, dp);
        if(s.charAt(i) != prevChar) {
            dontDelete = 1 + dfs(s, k, i+1, s.charAt(i), 1, dp); 
        }
        
        else if(s.charAt(i) == prevChar) {
            if(prevFreq == 1) {
                dontDelete = 1 + dfs(s, k, i+1, s.charAt(i), 2, dp);
            }
            else if(prevFreq == 9) {
                dontDelete = 1 + dfs(s, k, i+1, s.charAt(i), 10, dp);
            }
            else if(prevFreq == 99) {
                 dontDelete = 1 + dfs(s, k, i+1, s.charAt(i), 100, dp);
            } else {
                dontDelete = dfs(s,k,i+1, s.charAt(i), prevFreq+1, dp);
            }
        }
        return dp[i][k][prevChar-'a'][prevFreq] = Math.min(delete, dontDelete);
    }
}