class Solution {
    public int bestClosingTime(String s) {
        int n=s.length();
        int ty=0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='Y') ty++;
        }
        int min=n;int x=0,ans=-1;
        for(int i=0;i<=n;i++){
            int cy=x;
            int cn=i-x;
            int ly=ty-cy;
            int cur=cn+ly;
            if(cur<min){
                min=cur;
                ans=i;
            }
            if(i<n && s.charAt(i)=='Y') x++;
        }
        return ans;
    }
}