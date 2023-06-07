class Solution {
    public int minimizeArrayValue(int[] a) {
        int n=a.length;
        int l=0,r=0;
        for(int x:a){
            r=Math.max(r,x);
        }
        if(a[0]==r) return r;
        int ans=r;
        while(l<=r){
            int m=l+(r-l)/2;
            if(help(a,m,n)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean help(int a[],int m,int n){
        long s=0;
        for(int i=0;i<n;i++){
            s+=a[i];
            if(s>(long)(i+1)*m) return false;
        }
        return true;
    }
}