class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 2;//for case when aur ans is at last index to make nums[low] as final answer took this
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid % 2 == 0) {
                // Checking whether we are in right half on right half of ans first occ is on odd index and second occ. on even index
                if (nums[mid] != nums[mid + 1]) //mid is even so to be in right half this should be the second occurence and if it is then we want to go to left so h=m-1
                    
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            } else {
                // Checking whether we are in right half
                if (nums[mid] == nums[mid + 1])
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            }
        }
        return nums[low];
    }
}