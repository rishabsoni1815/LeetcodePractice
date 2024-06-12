class Solution {
    public void sortColors(int[] a) {
        int i=0,j=a.length-1,k=0;
        while(k<=j){
            if(a[k]==0 && k!=i){//k!=i as if already correct ele is present this will again n again swap so dont swap only
                swap(a,k,i);
                i++;
            }else if(a[k]==2){
                swap(a,k,j);
                j--;
            }
            else k++;
        }
    }
    void swap(int a[],int k,int i){
        int t=a[i];
        a[i]=a[k];
        a[k]=t;
    }
}