class Solution {
    public int removeDuplicates(int[] nums) {
        int s=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[s]=nums[i];
                s++;
            }
        }
        return s;
    }
}