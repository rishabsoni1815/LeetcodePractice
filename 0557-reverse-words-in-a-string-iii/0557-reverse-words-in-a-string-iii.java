class Solution {
    public String reverseWords(String s) {
       int n=s.length(),j=0;
       StringBuilder ans=new StringBuilder();
       while(j<n){
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
/*
//convert to char array

public class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; } // move j to the end of the word
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}

*/