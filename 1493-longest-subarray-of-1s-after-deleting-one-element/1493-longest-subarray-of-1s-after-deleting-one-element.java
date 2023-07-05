class Solution {
    public int longestSubarray(int[] a) {
        int ans=0,cur=0,prev=0,n=a.length,i=0;
        boolean zero=false;
        while(i<n){
            if(a[i]==1){
                cur++;
            }else{
                zero=true;
                ans=Math.max(ans,prev+cur);
                prev=cur;
                cur=0;
            }
            i++;
        }
        ans=Math.max(ans,prev+cur);
        return zero?ans:ans-1;
    }
}