class Solution {
   public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;// if found diff then place at starting and do i++ else just iterate j++
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
     }
}