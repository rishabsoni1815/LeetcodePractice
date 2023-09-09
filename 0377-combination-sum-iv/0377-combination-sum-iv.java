class Solution {
    public int combinationSum4(int[] a, int t) {
        int n=a.length;
        // Integer dp[][]=new Integer[n][t+1];//i doesn't matter as trying all nos in help fn of the array see through observation that we only need t
        
        Integer dp[]=new Integer[t+1];
        return help(a,0,n,t,dp);
    }
    int help(int a[],int i,int n,int t,Integer dp[]){
        if(t==0) return 1;
        if(t<0 || i>=n) return 0;
        int ans=0;
        if(dp[t]!=null) return dp[t];
        for(int j=0;j<n;j++){
            ans+=help(a,j,n,t-a[j],dp);
        }
        return dp[t]=ans;
    }
}