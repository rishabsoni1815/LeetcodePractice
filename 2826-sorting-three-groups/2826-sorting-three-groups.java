class Solution {
    public int minimumOperations(List<Integer> g) {
        int n=g.size();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=g.get(i);
        }
        Integer dp[][]=new Integer[n][4];
        return help(a,n-1,3,dp);
    }
    int help(int nums[],int i,int last,Integer dp[][]){
        if(i < 0 ) return 0;
        if(last < 1) return 1000;
        if(dp[i][last] != null ) return dp[i][last];
        int res = Integer.MAX_VALUE;
        if(last == nums[i]) res = help(nums, i-1, last, dp);
        else{
            if(nums[i] < last) {
                res = Math.min(res, help(nums, i-1, nums[i], dp));
                res = Math.min(res, 1 + help(nums, i-1, last, dp));
            }else{
                res = Math.min(res, 1 + help(nums, i-1, last, dp));  
                res = Math.min(res, 1 + help(nums, i-1, last-1, dp)); 
            }
        }
        return dp[i][last] = res;
    }
}