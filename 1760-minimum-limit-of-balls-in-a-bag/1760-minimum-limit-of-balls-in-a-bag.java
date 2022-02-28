class Solution {
    public int minimumSize(int[] a, int max) {
        int maxe=a[0];
        for(int u:a) maxe=Math.max(maxe,u);
        int l=1,r=maxe,ans=maxe;
        while(l<=r){
            int m=l+(r-l)/2;
            if(help(a,max,m)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean help(int a[],long max,long m){
        long ans=0;
        for(int i=0;i<a.length;i++){
            if(a[i] > (max+1)*m) return false;
            if(a[i]>m) {
                if(a[i]%m==0) ans+=(a[i]/m -1);
                else ans+=(a[i]/m);
            }
        }
        return ans<=max;
    }
}