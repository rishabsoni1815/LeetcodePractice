class Solution {
    public int findKthPositive(int[] a, int k) {
        int n=a.length;
        int h[]=new int[n];
        for(int i=0;i<n;i++) h[i]=a[i];
        for(int i=0;i<n;i++){
            if(i==0){
                h[i]=a[i]-0-1;
            }else{
                h[i]=a[i]-a[i-1]-1;
            }
            if(i!=0) h[i]+=h[i-1];
        }
        int l=0,r=n-1,ans=n;
        while(l<=r){
            int m=l+(r-l)/2;
            if(h[m]>=k){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        int x=0;
        if(ans==n) x=a[n-1]+(k-h[n-1]);
        else x=a[ans]-(h[ans]-k+1);
        return x;
    }
}