class Solution {
    public String compressedString(String s) {
        StringBuilder ans=new StringBuilder();
        int i=0,n=s.length();
        while(i<n){
            int cnt=0;
            char c=s.charAt(i);
            while(i<n && cnt<9 && s.charAt(i)==c){
                i++;
                cnt++;
            }
            ans.append(cnt).append(c);
        }
        return ans.toString();
    }
}