class Solution {
    public int minSpeedOnTime(int[] a, double h) {
        int n=a.length;
        int l=1,r=10000001,ans=-1;
        while(l<=r){
            int m= l+(r-l)/2;
            if(help(a,h,m)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean help(int a[],double h,int m){
        double k=0.0;
        for(int i=0;i<a.length-1;i++){
            k+=Math.ceil((double)a[i]/m);
        }
        k+=((double)a[a.length-1]/m);
        return k<=h;
    }
}