class Solution {
    public int minimizedMaximum(int n, int[] a) {
        int maxe=a[0];
        for(int u:a) maxe=Math.max(maxe,u);
        int l=1,r=maxe,ans=maxe;
        while(l<=r){
            int m=l+(r-l)/2;
            if(help(a,n,m)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
     boolean help(int a[],long n,long m){
        long ans=0;
        for(int i=0;i<a.length;i++){
            n-=(long)(Math.ceil((double)a[i]/m));
            if(n<0) return false;
        }
        return true;
    }
}