class Solution {
    public int minimizeTheDifference(int[][] a, int t) {
        int n=a.length;
        int m=a[0].length;
        int dp[][]=new int[n][5001];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
       return help(0,0,a,t,n,m,dp);
    }
    int help(int i,int sum,int a[][],int t,int n,int m,int dp[][]){
        if(i==n){
            return Math.abs(t-sum);
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int min=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min=Math.min(min,help(i+1,sum+a[i][j],a,t,n,m,dp));
        }
        return dp[i][sum]=min;
    }
    /*
    can save loop of initialist by-> 
    
    public int minimizeTheDifference(int[][] mat, int target) {
        Integer[][] dp = new Integer[mat.length][5001];
        return minDiff(mat, 0, target,0, dp);
    }
    
    public int minDiff(int[][] mat,int index,int target, int val, Integer[][] dp){
        if(index == mat.length){
            return Math.abs(val - target);
        }
        if(dp[index][val] != null){
            return dp[index][val];
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < mat[0].length; i++){
            res = Math.min(res, minDiff(mat, index + 1, target, val + mat[index][i], dp));
        }
        
        return dp[index][val] = res;
    }
    
    
    */
}