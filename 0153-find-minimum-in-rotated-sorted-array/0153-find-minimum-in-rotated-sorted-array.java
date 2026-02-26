class Solution {
    public int findMin(int[] a) {
        //https://www.youtube.com/watch?v=nhEMDKMB44g&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=7
        int n=a.length;
        int i=0,j=n-1,ans=Integer.MAX_VALUE;
        while(i<=j){
            int m=i+(j-i)/2;
           if(m-1>0 && a[m-1]>a[m]) ans=Math.min(ans,a[m]);
           if(m+1<n && a[m+1]>a[m]) ans=Math.min(ans,a[m]);
           if(a[m]>a[i]) {
                ans=Math.min(ans,a[i]);
                i=m+1;
           }
           else {
                ans=Math.min(ans,a[j]);
                j=m-1;
           }
        }
        return ans;
    }
}