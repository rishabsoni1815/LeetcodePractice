class Solution {
    public int minDays(int[] a, int c, int k) {
        int n=a.length,max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,a[i]);
        }
        int l=0,r=max+1,ans=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(check(a,m,c,k)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean check(int a[],int m,int c,int k){
        int x=0,ans=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=m){
                x++;
            }else{
                x=0;
            }
            if(x==k){
                ans++;
                x=0;
            }
        }
        return ans>=c;
    }
}