class Solution {
    int dir[]={-1,0,1};
    public int cherryPickup(int[][] a) {
        int n=a.length,m=a[0].length;
        Integer dp[][][]=new Integer[n+1][m+1][m+1];
        return help(0,0,m-1,a,n,m,dp);
    }
    int help(int i,int j,int l,int a[][],int n,int m,Integer dp[][][]){//as i+1 is awlays there so no need of (i,j) ans (k,l) only (i,j) ans (i,l) are enough as k is always same as i
        if(i==n) return 0;
        if(dp[i][j][l]!=null) return dp[i][j][l];
        int sum=a[i][j]+a[i][l];
        if(j==l) sum-=a[i][j];
        int ans=0;
        for(int n1=0;n1<3;n1++){
            for(int n2=0;n2<3;n2++){
                if(i+1<n && j+dir[n1]<m && j+dir[n1]>=0 && l+dir[n2]<m && l+dir[n2]>=0) ans=Math.max(ans,help(i+1,j+dir[n1],l+dir[n2],a,n,m,dp));
            }
        }
        return dp[i][j][l]=ans+sum;
    }
}