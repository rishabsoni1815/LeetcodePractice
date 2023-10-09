class Solution {
    public int[] searchRange(int[] a, int t) {
        int n=a.length;
        int l=0,r=n-1;
        int ans[]=new int[2];ans[0]=-1;
        while(l<=r){
            int m=(l+(r-l)/2);
            if(a[m]>=t){
                if(a[m]==t) ans[0]=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        l=0;r=n-1;ans[1]=-1;
        while(l<=r){
            int m=(l+(r-l)/2);
            if(a[m]<=t){
                if(a[m]==t) ans[1]=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ans;
    }
}