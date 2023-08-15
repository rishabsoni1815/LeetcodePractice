class Solution {
    public int[] pivotArray(int[] a, int p) {
        int n=a.length;
        
        //dutch national flag algo will give larger elements in reverse order i.e [9,12,5,10,14,3,10,11] -> [9,5,3,10,10,11,14,12] // or any other random so make a new array n do noin place sol.
        // int k=0,i=0,j=n-1;
        // while(k<=j){
        //     if(a[k]<p){
        //         int temp=a[i];
        //         a[i]=a[k];
        //         a[k]=temp;
        //         i++;
        //         k++;
        //     }else if(a[k]>p){
        //         int temp=a[j];
        //         a[j]=a[k];
        //         a[k]=temp;
        //         j--;
        //     }
        //     else k++;
        // }
        // return a;
        
        int res[]=new int[n];
        int i=0,j=n-1,l=0,r=n-1;//start from last for >p elements to maintain order
        while(i<n){
            if(a[i]<p) res[l++]=a[i];
            if(a[j]>p) res[r--]=a[j];
            i++;
            j--;
        }
        while(l<=r) res[l++]=p;
        return res;
    }
}