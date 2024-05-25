class Solution {
    public List<String> wordBreak(String s, List<String> d) {
        HashSet<String>h=new HashSet<>();
        for(int i=0;i<d.size();i++){
            h.add(d.get(i));
        }
        List<String> dp[]=new ArrayList[s.length()];
        return help(0,s,h,dp);
    }
    List<String> help(int i,String s,HashSet<String>h,List<String> dp[]){
        if(i>=s.length()){
            List<String>ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        if(dp[i]!=null) return dp[i];
        StringBuilder c=new StringBuilder();
        List<String>ans=new ArrayList<>();
        for(int j=i;j<s.length();j++){
            c.append(s.charAt(j));
            if(h.contains(c.toString())){
                List<String>clist=help(j+1,s,h,dp);
                for(String cur :clist){
                   if(cur.length()>0) ans.add(c.toString()+" "+cur);
                   else ans.add(c.toString());
                }
            }
        }
        dp[i]=ans;
        return ans;
    }
}