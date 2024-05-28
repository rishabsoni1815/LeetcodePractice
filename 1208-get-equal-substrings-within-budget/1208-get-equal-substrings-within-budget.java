class Solution {
    public int equalSubstring(String s, String t, int m) {
        int ans=0;
        int i=0,j=0,n=s.length();
        int sum=0;
        while(j<n){
            sum+=Math.abs((int)s.charAt(j)-t.charAt(j));
            while(i<=j && sum>m){
                sum-=Math.abs((int)s.charAt(i)-t.charAt(i));
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}