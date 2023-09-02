class Solution {
    public int minExtraChar(String s, String[] d) {
        int n=s.length(),m=d.length;
        HashSet<String>h=new HashSet<>();
        for(String f:d) h.add(f);
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--){
            StringBuilder c=new StringBuilder();
            dp[i]=1+dp[i+1];
            for(int j=i;j<n;j++){
                c.append(s.charAt(j));
                if(h.contains(c.toString())){
                    dp[i]=Math.min(dp[i],dp[j+1]);
                }           
            }
        }
        return dp[0];
    }
}