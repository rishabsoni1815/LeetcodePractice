class Solution {
    //https://leetcode.com/problems/remove-boxes/discuss/645838/Evolve-from-intuition-to-dp
    //https://leetcode.com/problems/remove-boxes/discuss/1402561/C%2B%2BJavaPython-Top-down-DP-Clear-explanation-with-Picture-Clean-and-Concise
    public int removeBoxes(int[] a) {
        int n=a.length;
        Integer dp[][][]=new Integer[n+1][n+1][n+1];
        return help(1,0,n-1,n,a,dp);//a[i] is there so streak=1
    }
    int help(int streak,int i,int j,int n,int a[],Integer dp[][][]){
       if(i>j) return 0;
        // if(i==j) return 1;//no as prev streak can be there
        if(dp[streak][i][j]!=null) return dp[streak][i][j];
        int max=(streak*streak)+help(1,i+1,j,n,a,dp);//end streak here and streak =1 as a[i+1] is there on start so 1 not 0
        for(int k=i+1;k<=j;k++){
            if(a[k]==a[i]){
                max=Math.max(max,help(streak+1,k,j,n,a,dp)+help(1,i+1,k-1,n,a,dp));
                //help(streak+1,k,j,n,a,dp)-> include a[k] with prev strak till i so streak+1 (a[k]=a[i] so 1 not 0) and now find from a[k,j]
                //help(1,i+1,k-1,n,a,dp)-> left is a[i+1...k-1] so add its answer streak is as a[i+1] is there 1 not 0 as in above only ans is  help(1,0,n-1,n,a,dp); not help(0,0,n-1,n,a,dp);streak is 1 initialised
            }
        }
        return dp[streak][i][j]=max;
    }
}