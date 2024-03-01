class Solution {
    public String maximumOddBinaryNumber(String s) {
        char c[]=s.toCharArray();
        int st=0,l=0;
        for(int i=0;i<s.length();i++){
            if(c[i]=='1'){
                l=st;
                c[i]='0';
                c[st]='1';
                st++;
            }
        }
        c[s.length()-1]='1';
        if(l!=s.length()-1) c[l]='0';
        return String.valueOf(c);
    }
}