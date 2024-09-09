
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int left=0,right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid>0 && mid<n-1){
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
                else if(nums[mid-1]>nums[mid]){
                    right=mid-1;
                }else left=mid+1;
            }else if(mid==0){
                if(nums[0]>nums[1]) return 0;
                return 1;
            }else if(mid==n-1){
                if(nums[n-1]>nums[n-2]) return n-1;
                return n-2;
            }
        }
        return -1;
    }
}
