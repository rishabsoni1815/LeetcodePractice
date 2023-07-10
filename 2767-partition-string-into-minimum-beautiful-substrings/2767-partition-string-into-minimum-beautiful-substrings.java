class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int n=s.length();
        if(s.charAt(0)=='0') return -1;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
       help(0,0,s,n,dp);
        return dp[0];
    }
    int help(int l,int i,String s,int n,int dp[]){
        if(i==n) {
            if(check(s.substring(l,i))){
                return dp[i]=1;
            }else{
                return dp[i]=-1;
            }
        }
            int o1=Integer.MAX_VALUE;
            if(check(s.substring(l,i)) && s.charAt(i)=='1'){
                int yy=help(i,i+1,s,n,dp);
                if(yy!=-1) o1=1+yy;
            }
                int yy=help(l,i+1,s,n,dp);
                if(yy!=-1) o1=Math.min(o1,yy);
            
        o1=(o1==Integer.MAX_VALUE?-1:o1);
        return dp[i]=o1;
    }
    boolean check(String s){
        if(s.equals("1")||s.equals("101")||s.equals("11001")||s.equals("1111101")||s.equals("1001110001")||s.equals("110000110101")||s.equals("11110100001001")||s.equals("10011000100101101")) return true;
        return false;
    }
}