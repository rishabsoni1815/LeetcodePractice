class Solution {
public:
    int helper(vector<int>& arr)
    {
         int n = arr.size();
         vector<int> dp(n, 1); // dp[i] stores the length of the LIS ending at arr[i]
    vector<int> ct(n, 1);
        int maxi=1;
        for(int i=0;i<arr.size();i++)
        {
            for(int prev=0;prev<i; prev++)
            {
                if(arr[prev]<arr[i] && dp[prev]+1>dp[i])
                {
                    dp[i]=dp[prev]+1;
                    ct[i]=ct[prev];
                }
                else if (arr[prev] < arr[i] && dp[prev] + 1 == dp[i]) {
                // Increase the count
                ct[i] = ct[i] + ct[prev];
            }
                    
            }
             maxi = max(maxi, dp[i]);
        }
        int numberOfLIS = 0;

    for (int i = 0; i < n; i++) {
        if (dp[i] == maxi) {
            numberOfLIS += ct[i];
        }
    }

    return numberOfLIS;
    }
    int findNumberOfLIS(vector<int>& nums) {
        return helper(nums);
    }
};