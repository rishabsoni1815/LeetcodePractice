class Solution {
    public int maxFreqSum(String s) {
        int h[]=new int[26];
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'a']++;
        }
        int max1=0,max2=0;
        for(int i=0;i<26;i++){
            if(isVowel((char)('a'+i))){
                max1=Math.max(max1,h[i]);
            }else{
                max2=Math.max(max2,h[i]);
            }
        }
        return max1+max2;
    }
    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}