class Solution {
    public int longestOnes(int[] c, int k) {
        int l=0,r=0,ans=0,n=c.length,cnt=0;
        //variable size sliding window
		while(r<n){
            if(c[r]==0) cnt++;
            if(cnt<=k){
                ans=Math.max(ans,r-l+1);
                r++;
            }else {
                while(cnt>k && l<n){
                    if(c[l]==0) cnt--;
                    l++;
                }
                r++;
            }
        }
		return ans;
    }
}