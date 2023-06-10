class Solution {
    public int minEatingSpeed(int[] a, int h) {
        int max=0,n=a.length;
        for(int i:a) max=Math.max(max,i);
        int l=0,r=max,ans=max;
        while(l<=r){
            int m=l+(r-l)/2;
            if(help(m,a,h,n)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean help(int m,int a[],int h,int n){
        int res=0;
        for(int i=0;i<n;i++){
            res+=Math.ceil((double)a[i]/m);
        }
        return res<=h;
    }
}