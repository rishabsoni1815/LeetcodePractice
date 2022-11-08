class Solution {
    public String makeGood(String a) {
        StringBuilder s=new StringBuilder();
        int i=0,n=a.length();
        while(i<n){
            char c=a.charAt(i);
            char p='-';
            if(s.length()!=0) {
                p=s.charAt(s.length()-1);
                if(c-'a'==p-'A'||c-'A'==p-'a'){
                    s.deleteCharAt(s.length()-1);
                }else{
                    s.append(c);
                }
            }else{
                s.append(c);
            }
            i++;
        }
        return s.toString();
    }
}