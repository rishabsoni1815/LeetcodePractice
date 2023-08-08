class Solution {
    public int search(int[] a, int target) {
         int low = 0, high = a.length - 1; 
        while(low <= high) {
            int mid = (low + high) >> 1; 
            if(a[mid] == target) return mid; 
            
            // the left side is sorted then check if target is in left half if not then l=m+1 is only option
            if(a[low] <= a[mid]) {
                if(target >= a[low] && target <= a[mid]) {
                    high = mid - 1; 
                }
                else {
                    low = mid + 1; 
                }
            }
            else {//if right half is sorted then chechk if it is in right half,if not then h=m+1
                if(target >= a[mid] && target <= a[high]) {
                    low = mid + 1; 
                }
                else {
                    high = mid - 1; 
                }
            }
        } 
        return -1; 
    }
}