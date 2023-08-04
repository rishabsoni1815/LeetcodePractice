class Solution {
    public boolean wordBreak(String s, List<String> a) {
        int n=s.length();
        HashSet<String>h=new HashSet<>();
        for(String y:a) h.add(y);
        Boolean dp[]=new Boolean[n];
        return help(0,s.length(),s,h,dp);
    }
    boolean help(int i,int n,String s,HashSet<String>h,Boolean dp[]){
        if(i>=n) return true;
        StringBuilder temp=new StringBuilder();
        if(dp[i]!=null) return dp[i];
        // boolean ans=false;
        for(int j=i;j<n;j++){
            temp.append(s.charAt(j));
            if(h.contains(temp.toString())){
                // ans|=help(j+1,n,s,h,dp);//optimise as break when found
                if(help(j+1,n,s,h,dp)) return dp[i]=true;
                
            }
        }
        return dp[i]=false;
    }
}