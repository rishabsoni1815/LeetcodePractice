class Solution {
    public String longestPrefix(String s) {
        int n=s.length();
        int lps[]=new int[n];
        lps[0]=0;
        int max=0;String ans="";
        for(int i=1;i<n;i++){
            int prev=lps[i-1];
            while(prev>0 && s.charAt(prev)!=s.charAt(i)){
                prev=lps[prev-1];
            }
            lps[i]=prev+(s.charAt(prev)==s.charAt(i) ? 1:0);
        }
        return s.substring(0,lps[n-1]);
    }
}