public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l = 0, r = nums.length - 1;
        while (l <=r) {
            int mid = (l + r) / 2;
            if(mid>0&&mid<nums.length-1){
                if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) return mid;
                else if(nums[mid-1]>nums[mid]){//coz if on the left the arr. is increasing then there are more chances that we will find a peak so r=mid-1
                  r=mid-1;
                }else{
                  l=mid+1;
                }
            }else if(mid==0){
                if(nums[0]>nums[1]) return 0;
                else return 1;
            }
            else if(mid==nums.length-1){
                if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
                else return nums.length-2;
            }
        }
        return -1;
    }//aditya verma
}