class Solution {
    public int[] diStringMatch(String s) {
        int n=s.length();
        int ans[]=new int[s.length()+1];
        int i=0,j=n;
        for(int ii=0;ii<n;ii++){
            if(s.charAt(ii)=='I'){
                ans[ii]=i;
                i++;
            }else{
                ans[ii]=j;
                j--;
            }
        }
        if(s.charAt(n-1)=='I') ans[n]=i;
        else ans[n]=j;
        return ans;
    }
}