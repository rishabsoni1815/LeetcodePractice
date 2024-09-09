class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length,index=n,left=0,right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                index=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return index;
    }
}