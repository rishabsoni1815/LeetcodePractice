class Solution {
    public int strangePrinter(String s) {
        int n=s.length();
        Integer dp[][]=new Integer[n][n];
        return help(0,n-1,n,s,dp);
    }
    int help(int i,int j,int n,String s,Integer dp[][]){
        if(i>j) return Integer.MAX_VALUE-1;
        if(i==j) return 1;
        
        //optimise it as if s[j]==s[j-1] then it's equivalent to printing substring s[i...j-1].
        if(j>0 && s.charAt(j)==s.charAt(j-1)) return dp[i][j]=help(i, j-1, n,s,dp);
        
       //optimise it as if s[i]==s[i+1] then it's equivalent to printing substring s[i+1...j].
        if(i<n-1 && s.charAt(j)==s.charAt(j-1)) return dp[i][j]=help(i+1, j,  n,s,dp);
        
        
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=help(i,j-1,n,s,dp);// abcda can be ans of abcd only as we can make aaaaa and then make it abcda so ans of abcda is of abcd only
        }else{
            if(dp[i][j]!=null) return dp[i][j];
            int max=1+help(i,j-1,n,s,dp);  //extra s[j] after string s[i...j-1]
            for(int k=i+1;k<j;k++){//or for(int k=i+1;k<=j;k++) as s[i]!=s[j] we know only 
                if(s.charAt(k)==s.charAt(j)){
                    max=Math.min(max,help(i,k-1,n,s,dp)+help(k,j-1,n,s,dp));// if s[k]=s[j] then above rule applies of abcda same as abcd so help(k,j-1) and ans is this + left string that is s[i...k-1] 
                }
            }
            return dp[i][j]=max;
        }
    }
}