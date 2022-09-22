class Solution {
    public String reverseWords(String s) {
       int n=s.length(),i=0,j=0;
       StringBuilder ans=new StringBuilder();
       while(j<n&&i<n){
           StringBuilder t=new StringBuilder();
           while(j<n && s.charAt(j)!=' '){
               t.append(s.charAt(j));
               j++;
           }
           ans.append(t.reverse().toString());
          if(j<n) ans.append(s.charAt(j));
           j++;
       }
        return ans.toString();
    }
}