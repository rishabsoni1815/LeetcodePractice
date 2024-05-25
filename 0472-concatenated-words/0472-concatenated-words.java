class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] a) {
        int n=a.length;
        //Time Complexity: O(total no.of words * (n^3)) where n = avg length of each word.
        HashSet<String>h=new HashSet<>();
        Arrays.sort(a,(x,y)->(x.length()-y.length()));
        // for(int i=0;i<n;i++){//do on the fly so only small are used to make big
        //     h.add(a[i]);
        // }
        List<String>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            Boolean dp[]=new Boolean[a[i].length()+1];
            if(help(0,a[i],h,dp)){//just this make cat and dog to be true too so sort a (not alphabaetically asc or desc just length wise asc desc) and just use smaller to make bigger
                ans.add(a[i]);
            }
            h.add(a[i]);
        }
        return ans;
    }
    boolean help(int i,String s,HashSet<String>h,Boolean dp[]){
        if(i>=s.length()) return true;
        StringBuilder c=new StringBuilder();
        boolean ans=false;
        String cur=s.substring(i);
        if(dp[i]!=null) return dp[i];
        for(int j=i;j<s.length();j++){
            c.append(s.charAt(j));
            if(h.contains(c.toString())){
                ans|=help(j+1,s,h,dp);
            }
        }
        dp[i]=ans;
        return ans;
    }
}