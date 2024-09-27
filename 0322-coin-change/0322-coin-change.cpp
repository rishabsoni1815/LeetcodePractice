class Solution {
public:
    int helper(vector<vector<int>> &dp,vector<int> &arr, int sum , int i )
{
    if(sum==0)
        return 0;
    if(sum<0 || i==arr.size())
        return INT_MAX-1;
    if(dp[i][sum]!=-1)
    return dp[i][sum];
    int Pick = 1 + helper(dp,arr,sum - arr[i],i);
    int nonPick= helper(dp,arr ,sum ,i+1);
    dp[i][sum]=min( Pick, nonPick);
    return dp[i][sum] ;
}
    int coinChange(vector<int>& coins, int amount) {
        int n= coins.size();
       vector<vector<int>> dp(n,vector<int>(amount+1,-1));
        int result = helper(dp,coins,amount,0);
        return (result == INT_MAX-1) ? -1 : result; 
        
    }
};