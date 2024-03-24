class Solution {
    public int findDuplicate(int[] nums) {
        //our node is nums[x] not x so slow=nums[start] where start=nums[0]
        int start=nums[0];
        int slow=nums[start];
        int fast=nums[nums[start]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        
        //finding intersection
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}