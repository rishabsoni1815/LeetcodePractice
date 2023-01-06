class Solution {
    public int maxIceCream(int[] c, int k) {
        int n=c.length;
        Arrays.sort(c);
        long a[]=new long[n];
        a[0]=c[0];
        for(int i=1;i<n;i++){
            a[i]=c[i]+a[i-1];
        }
        int ans=-1,l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]<=k){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ans+1;
    }
}