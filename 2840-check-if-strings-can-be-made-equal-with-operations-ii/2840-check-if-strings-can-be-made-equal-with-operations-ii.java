class Solution {
    public boolean checkStrings(String a, String b) {
        int n= a.length();
        int he1[]=new int[26];
        int ho1[]=new int[26];
        int he2[]=new int[26];
        int ho2[]=new int[26];
        for(int i=0;i<n;i++){
            if(i%2==0) he1[a.charAt(i)-'a']++;
            else ho1[a.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            if(i%2==0) he2[b.charAt(i)-'a']++;
            else ho2[b.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(he1[i]!=he2[i] || ho1[i]!=ho2[i]) return false;
        }
        return true;
    }
}