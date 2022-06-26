class Solution {
    public void sortColors(int[] a) {
        int n=a.length,i=0,j=n-1,m=0,k=0;
        while(k<=j){
            if(a[k]==0){
                int t=a[k];
                a[k]=a[i];
                a[i]=t;
                i++;
                k++;
            }else if(a[k]==2){
                int t=a[k];
                a[k]=a[j];
                a[j]=t;
                j--;
            }else{
                k++;
            }
        }
    }
}