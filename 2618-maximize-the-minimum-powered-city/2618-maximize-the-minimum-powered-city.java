class Solution {
    public long maxPower(int[] a, int rr, int k) {
        int n=a.length;
        long sum=k;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        long l=0,r=sum,ans=sum;
        while(l<=r){
            long mid=(l+(r-l)/2);
            if(help(mid,a,rr,k)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    boolean help(long mid,int aa[],int r,int k){
        int a[]=new int[aa.length];
        for(int i=0;i<a.length;i++){
            a[i]=aa[i];
        }
        long csum=0;
        for(int i=0;i<=r;i++) csum+=a[i];
        for(int i=0;i<a.length;i++){
            if(i>0 && i+r<a.length){
                csum+=a[i+r];
            }
            if(csum<mid){
                long y=mid-csum;
                if(k<y) return false;
                a[Math.min(i+r,a.length-1)]+=y;
                csum+=y;
                k-=y;
            }
            if(i>=r){
                csum-=a[i-r];
            }
        }
        return true;
    }
}