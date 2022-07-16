class Solution {
    public int findUnsortedSubarray(int[] a) {
        int n=a.length;
        int l=0,r=0;
        //imp point-> that subarray is random it is not sorted desc. order
        //so to find end of array imp is after that all elements to right should be greater than all till found so there should be no a[i] which is les than max found till now
        //to find start, every element to left should be smaller than all found til now (travrse from right side) so no element should be greater than min found till now 
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]<max){
                r=i;
            }
            max=Math.max(max,a[i]);
        }
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            if(a[i]>min){
                l=i;
            }
            min=Math.min(min,a[i]);
        }
        return r-l >0 ? r-l+1 : 0;
    }
}