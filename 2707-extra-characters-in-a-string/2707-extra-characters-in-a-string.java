class Solution {
    public int minExtraChar(String s, String[] a) {
        int n=s.length();
        HashSet<String>h=new HashSet<>();
        for(String y:a) h.add(y);
        Integer dp[]=new Integer[n];
        return help(0,s.length(),s,h,dp);
    }
     int help(int i,int n,String s,HashSet<String>h,Integer dp[]){
        if(i>=n) return 0;
        StringBuilder temp=new StringBuilder();
        if(dp[i]!=null) return dp[i];
        int ans=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            temp.append(s.charAt(j));
            if(h.contains(temp.toString())){
                ans=Math.min(ans,help(j+1,n,s,h,dp));
            }
            ans=Math.min(ans,(j-i+1)+help(j+1,n,s,h,dp));
            
        }
        return dp[i]=ans;
    }
}