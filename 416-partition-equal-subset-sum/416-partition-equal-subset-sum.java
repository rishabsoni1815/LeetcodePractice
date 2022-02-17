class Solution {
    // public boolean canPartition(int[] nums) {
    //     int sum=0;
    //     int n=nums.length;
    //     for(int i:nums)sum+=i;
    //     if(sum%2!=0) return false;
    //     int target=sum/2;
    //     boolean dp[][]=new boolean[n][target+1];
    //     for(int i=0;i<n;i++) dp[i][0]=true;
    //    if(nums[0]<=target) dp[0][nums[0]]=true;
    //     for(int i=1;i<n;i++){
    //         for(int j=0;j<=target;j++){
    //             dp[i][j]=dp[i-1][j];
    //             if(j>=nums[i]) dp[i][j]|=dp[i-1][j-nums[i]];
    //         }
    //     }
    //     return dp[n-1][target];
    // }
    
    
    // can space as only i-1 required
        public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i:nums)sum+=i;
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean prev[]=new boolean[target+1];
        // for(int i=0;i<n;i++) dp[i][0]=true; as this was so pre[0] would be true always
       if(nums[0]<=target) prev[nums[0]]=true;
        for(int i=1;i<n;i++){
        boolean cur[]=new boolean[target+1];
            for(int j=0;j<=target;j++){
                if(j==0) prev[j]=true;
                cur[j]=prev[j];
                if(j>=nums[i]) cur[j]|=prev[j-nums[i]];
            }
            prev=cur;
        }
        return prev[target];
    }
}