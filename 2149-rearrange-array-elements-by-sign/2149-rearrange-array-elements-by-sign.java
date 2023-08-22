class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] out = new int [nums.length];
        int j = 0;
        int k = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                out[j] = nums[i];
                j += 2;
            }else {
                out[k] = nums[i];
                k += 2;
            }
        }
        return out;
    }
    //o(n^2)- time but soace - o(1) https://leetcode.com/problems/rearrange-array-elements-by-sign/discuss/2678355/O(1)-Space-complexity-explained
}