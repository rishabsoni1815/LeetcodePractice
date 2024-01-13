class Solution {
    public int minSteps(String s, String t) {
        int h[]=new int[26];
        for(int i=0;i<t.length();i++){
            h[t.charAt(i)-'a']++;
        }
        int ans=0;
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(h[i]<0) ans+=(Math.abs(h[i]));
        }
        return ans;
    }
}