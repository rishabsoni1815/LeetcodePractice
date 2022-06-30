class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
      //max of subarray [0,n-1] and [1,n] 
        return Math.max(help(Arrays.copyOfRange(nums,1,nums.length)),help(Arrays.copyOfRange(nums,0,nums.length-1)));
    }
    public int help(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
		
        if (n >= 1) {
            dp[0] = nums[0];
        }
        
        if (n >= 2) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        
        for (int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[n - 1];
    }
}