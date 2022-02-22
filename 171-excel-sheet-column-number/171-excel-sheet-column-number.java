class Solution {
    public int titleToNumber(String s) {
        int ans=0;
        int c=1;
        for(int i=s.length()-1;i>=0;i--){
            int x=s.charAt(i)-'A'+1;
            ans+=(c*x);
            c*=26;
        }
        return ans;
    }
}