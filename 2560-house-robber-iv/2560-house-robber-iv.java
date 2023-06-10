class Solution {
    public int minCapability(int[] a, int k) {
        int max=a[0],n=a.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,a[i]);
        }
        int l=0,r=max,ans=max;
        while(l<=r){
            int m=l+(r-l)/2;
            if(help(m,a,k,n)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean help(int m,int a[],int k,int n){
        int x=0,prev=-2;
        for(int i=0;i<n;i++){
            if(a[i]<=m && (prev!=(i-1))){
                prev=i;
                x++;
            }
            if(x>=k) break;;
        }
        return x>=k;
    }
}