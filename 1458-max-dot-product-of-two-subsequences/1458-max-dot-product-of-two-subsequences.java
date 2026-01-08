class Solution 
{
    private Integer[][] dp;
    
    public int maxDotProduct(int[] nums1, int[] nums2) 
    {
        dp = new Integer[nums1.length][nums2.length];
        return FindMaxDotProduct(nums1, nums2, 0, 0);
    }
    
    public int FindMaxDotProduct(int[] nums1, int[] nums2, int i, int j)
    {
        if(i == nums1.length || j == nums2.length)
            return Integer.MIN_VALUE;
        
        if(dp[i][j] != null)
            return dp[i][j];

        int f_excl = FindMaxDotProduct(nums1, nums2, i + 1, j);
        
        int s_excl = FindMaxDotProduct(nums1, nums2, i, j + 1);
        
        int both_excl = FindMaxDotProduct(nums1, nums2, i + 1, j + 1);
        
        int incl = nums1[i] * nums2[j] + Math.max(both_excl, 0);//as can only take these 2 so max with 0 also
        
        int result = Math.max(Math.max(incl, f_excl), Math.max(s_excl, both_excl));
        
        dp[i][j] = result;
        
        return result;
    }
}