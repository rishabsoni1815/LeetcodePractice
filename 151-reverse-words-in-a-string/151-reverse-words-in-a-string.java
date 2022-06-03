class Solution {
    public String reverseWords(String s) {
        int n=s.length(),i=0,j=0;
        StringBuilder ans=new StringBuilder();//i is start of word and j is end 
        while(i<n){
            while(i<n && s.charAt(i)==' ') i++;
            j=i+1;
            while(j<n && s.charAt(j)!=' ') j++;
            if(i!=n) {
                if(ans.length()>0) ans.insert(0," ");
                ans.insert(0,s.substring(i,j));
            }
            i=j;
        }
        return ans.toString();
    }
}