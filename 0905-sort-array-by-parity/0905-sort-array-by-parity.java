class Solution {
    public int[] sortArrayByParity(int[] a) {
        int n=a.length;
        int t[]=new int[n];
        int a1=0;
        int b=n-1;
        for(int i=0;i<n;i++){
            if((a[i]&1)==0){
                t[a1]=a[i];
                a1++;
               // continue;
            }
            else{
                t[b]=a[i];
                b--;
            }
        }
        return t;
    }
}