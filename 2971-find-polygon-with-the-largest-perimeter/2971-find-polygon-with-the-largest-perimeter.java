class Solution {
    public long largestPerimeter(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        long psum[]=new long[n];
        for(int i=0;i<n;i++){
           if(i>0) psum[i]=psum[i-1];
            psum[i]+=a[i];
        }
        for(int i=n-1;i>0;i--){
            if(a[i]<psum[i-1]) return psum[i];
        }
        return -1;
    }
}