class Solution {
    public int searchInsert(int[] a, int t) {
       int n=a.length;
       int l=0,r=n-1;
       int ans=n;
       while(l<=r){
            int m=(l+(r-l)/2);
            if(a[m]==t) return m;
            if(a[m]>=t){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
       }
       return ans;
    }
}