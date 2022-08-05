class Solution {
    public int combinationSum4(int[] a, int t) {
        int n=a.length;
        Integer dp[]=new Integer[t+1];
        return help(a,t,dp);
    }
    //memoisation
    int help(int a[],int t,Integer dp[]){
        if(t==0) return 1;
        if(t<0) return 0;
        if(dp[t]!=null) return dp[t];
        int ans=0;
        for(int j=0;j<a.length;j++){
            ans+=help(a,t-a[j],dp);
        }
        return dp[t]=ans;
    }
    /*
    //tabulation
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int dp[]=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=1;j<=n;j++){
                if((i-nums[j-1])>=0){
                    dp[i]+=dp[i-nums[j-1]];
                }
            }//as coinn change permutation pepcoding
        }
        return dp[target];
    }
    
    */
}