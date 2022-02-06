class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length == 0) return 0;
        int i = 2;// just  elements in window must greater than array[i - 2]
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i-2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}