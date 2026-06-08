class Solution {
    public int[] pivotArray(int[] a, int p) {
        int k=0,n=a.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(a[i]<p) ans[k++]=a[i];
        }
        for(int i=0;i<n;i++){
            if(a[i]==p) ans[k++]=a[i];
        }
        for(int i=0;i<n;i++){
            if(a[i]>p) ans[k++]=a[i];
        }
        return ans;
    }
}