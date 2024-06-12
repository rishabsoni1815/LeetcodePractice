class Solution {
    public void sortColors(int[] a) {
        // make all zeroes come to start and all 2's to go at end one will come to there correct position automatically by using 3 pointers start=0,mid=0,end=n-1 when a[mid] is 0 swap with start and dpo mid++,if it is 1 do mid++,if it is 2 swap with end and do end--
        int n=a.length,i=0,j=n-1,k=0;
        while(k<=j){//as then it will replace all j's with 1 run tc then see
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