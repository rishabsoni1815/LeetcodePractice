class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length,p,q,i=0;
        while(i+1<n && nums[i+1]>nums[i]){
            i++;
        }
        p=i;
        while(i+1<n && nums[i+1]<nums[i]){
            i++;
        }
        q=i;
        while(i+1<n && nums[i+1]>nums[i]){
            i++;
        }
        return i==n-1 && p>0 && q>p && q<n-1;
    }
}