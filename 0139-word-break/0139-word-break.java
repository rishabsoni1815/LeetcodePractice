class Solution {
    public boolean wordBreak(String s, List<String> w) {//recursive is n! so dp as subproblems are repeating and independent
        int n=w.size();
        HashSet<String>h=new HashSet<>();
        for(int i=0;i<n;i++){
            h.add(w.get(i));
        }
        HashMap<Integer,Boolean>dp=new HashMap<>();
        return help(0,h,s,dp);
    }
    boolean help(int i,HashSet<String>h,String s,HashMap<Integer,Boolean>dp){
        if(i>=s.length()) return true;
        if(dp.containsKey(i)) return dp.get(i);
        boolean ans=false;
        StringBuilder c=new StringBuilder();
        for(int j=i;j<s.length();j++){
            c.append(s.charAt(j));
            if(h.contains(c.toString())){
                ans|=help(j+1,h,s,dp);
            }
        }
        dp.put(i,ans);
        return ans;
    }
}