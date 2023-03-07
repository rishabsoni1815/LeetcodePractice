class Solution {
    public long minimumTime(int[] a, int t) {
        int n=a.length;
        long max=a[0];
        for(int x:a) max=Math.max(max,x);
        long l=1,r=max*t,ans=r;
        while(l<=r){
            long m=l+(r-l)/2;
            if(h(m,a,t)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean h(long m,int a[],int t){
        long k=0;
        for(int i=0;i<a.length;i++){
            k+=((long)m/a[i]);
            if(k>=t) return true;
        }
        return false;
    }
}