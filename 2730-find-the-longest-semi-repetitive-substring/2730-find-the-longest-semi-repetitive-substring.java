class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n=s.length();
        int ans=1;
        int i=0,c=0,j=0;
        while(j<n-1){
            if(s.charAt(j)==s.charAt(j+1)){
                c++;
            }
            while(c>=2){
                ans=Math.max(ans,j-i+1);
                i++;
                if(s.charAt(i-1)==s.charAt(i)) c--;
            }
            j++;
        }
        ans=Math.max(ans,j-i+1);
        return ans;
    }
}