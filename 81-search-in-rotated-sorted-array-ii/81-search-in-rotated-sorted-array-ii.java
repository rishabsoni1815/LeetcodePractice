class Solution {
public boolean search(int[] a, int t) {
        int n=a.length;
        int i=0,j=n-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(a[mid]==t) return true;
            if(a[mid]==a[i]&&a[mid]==a[j]) { ///extra than search in sorted array i
                i++;
                j--;
            }
           else if(a[i]<=a[mid]){
               if(t>=a[i]&&t<=a[mid]) j=mid-1;
               else i=mid+1;
           }else{
               if(t>=a[mid]&&t<=a[j]) i=mid+1;
               else j=mid-1;
           }
        }
        return false;
    }
}