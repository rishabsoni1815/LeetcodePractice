class Solution {
    public boolean wordBreak(String s, List<String> w) {
        Set<String>h=new HashSet<>();
        for(int i=0;i<w.size();i++) h.add(w.get(i));
        // boolean dp[]=new boolean[s.length()+1];
        // dp[0]=true;
        //  for(int i=1; i <=s.length(); i++){
        //     for(int j=i-1; j>=0; j--){
        //         if(dp[j] && h.contains(s.substring(j, i))){
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return dp[s.length()];
        Boolean dp[]=new Boolean[s.length()];
        return help(0,s,h,dp);
    }
    //memoisation
    boolean help(int i,String s,Set<String>h,Boolean dp[]){
        if(i>=s.length()) return true;
        if(dp[i]!=null) return dp[i];
        boolean ans=false;
        for(int j=i;j<s.length();j++){
            if(h.contains(s.substring(i,j+1))){
                if(help(j+1,s,h,dp)){
                    return dp[i]=true;
                }
            }
        }
        return dp[i]=ans;
    }
    
    /*
    //tabulation
     public boolean wordBreak(String s, List<String> w) {
        Set<String>h=new HashSet<>();
        for(int i=0;i<w.size();i++) h.add(w.get(i));
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
         for(int i=1; i <=s.length(); i++){
            for(int j=i-1; j>=0; j--){
                if(dp[j] && h.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    
    */
}