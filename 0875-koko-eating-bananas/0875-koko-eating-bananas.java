class Solution {
    public int minEatingSpeed(int[] a, int h) {
        int n=a.length;
        long sum=0;
        for(int x:a) sum+=x;
        long l=0,r=sum,ans=sum;
        while(l<=r){
            long m=l+(r-l)/2;
            if(h(m,a,h)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return (int)ans;
    }
    boolean h(long m,int a[],int h){
        int k=0;
        for(int i=0;i<a.length;i++){
            k+=(Math.ceil((double)a[i]/m));
            if(k>h) return false;
        }
        return true;
    }
}