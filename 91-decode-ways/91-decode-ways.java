class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        Integer dp[]=new Integer[n];
        return help(0,n,s,dp);
    }
    int help(int i,int n,String s,Integer dp[]){
        if(i==n) return 1;
        if(i>n) return 0;
        int x=0;
        if(s.charAt(i)!='0') x=help(i+1,n,s,dp);
        int y=27;
        if(dp[i]!=null) return dp[i];
        if(i+1<n) y=Integer.valueOf(s.charAt(i)+""+s.charAt(i+1));
        if(y<=26 && s.charAt(i)!='0' && y!=0){
            return dp[i]=x+help(i+2,n,s,dp);
        }
        return dp[i]=x;
    }
}