class Solution {
    public int longestPalindrome(String s) {
        int h[]=new int[256];
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'0']++;
        }
        int ans=0;
        boolean odd=false;
        for(int i=0;i<h.length;i++){
            if(h[i]!=0 && h[i]%2==0){
                ans+=h[i];
            }else if(h[i]!=0 && h[i]%2!=0){
                ans+=h[i]-1;
                odd=true;
            }
        }
        if(odd) ans++;
        return ans;
    }
}