class Solution {
    public int strStr(String a, String b) {
        String s=b+"*"+a;
        int n=s.length();
        int lps[]=new int[n];
        for(int i=1;i<n;i++){
            int prev=lps[i-1];
            while(prev>0 && s.charAt(prev)!=s.charAt(i)){
                prev=lps[prev-1];
            }
            lps[i]=prev+(s.charAt(prev)==s.charAt(i) ? 1:0);
            if(lps[i]==b.length()) return i-b.length()-b.length();
        }
        return -1;
    }
}