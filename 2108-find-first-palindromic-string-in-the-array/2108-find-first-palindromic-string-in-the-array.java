class Solution {
    public String firstPalindrome(String[] a) {
        int n=a.length;
        for(int i=0;i<n;i++){
            if(is(a[i])) return a[i];
        }
        return "";
    }
    boolean is(String s){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        }
        return true;
    }
}