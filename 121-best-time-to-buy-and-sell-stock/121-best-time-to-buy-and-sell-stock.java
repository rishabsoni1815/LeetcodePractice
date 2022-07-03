class Solution {
    public int maxProfit(int[] a) {
        int n=a.length;
        int cur=a[0];
        int ans=0;
        for(int i=1;i<n;i++){
            if(a[i]>=cur){
                ans=Math.max(ans,a[i]-cur);
            }else{
                cur=a[i];
            }
        }
        return ans;
    }
}