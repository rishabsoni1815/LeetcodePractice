class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0,n=s.length(),m=t.length();
        if(n>m) return false;
        while(i<n && j<m){
            if(s.charAt(i)==t.charAt(j)){
                i++;j++;
            }else{
                j++;
            }
        }
        return i==n;
    }
}