class Solution {
    public int getCommon(int[] a, int[] b) {
        int i=0,j=0,n=a.length,m=b.length;
        while(i<n && j<m){
            if(a[i]==b[j]) return a[i];
            if(a[i]<b[j]) i++;
            else if(a[i]>b[j]) j++;//cant judge for == so did if() not just simple else
        }
        return -1;
    }
}