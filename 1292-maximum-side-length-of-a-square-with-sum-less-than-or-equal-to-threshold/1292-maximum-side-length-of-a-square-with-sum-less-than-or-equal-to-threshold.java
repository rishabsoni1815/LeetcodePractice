class Solution {
    public int maxSideLength(int[][] a, int t) {
        int n=a.length,m=a[0].length;
        int p[][]=prefix(a,n,m);
        int l=0,r=Math.min(n,m),ans=-1;//l and r are length of sq
        while(l<=r){
            int mid=l+(r-l)/2;
            if(help(mid,p,t,n,m)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans==-1 ? 0 : ans+1;
    }
    boolean help(int s,int p[][],int t,int n,int m){
        for(int i=0;i<n-s;i++){
            for(int j=0;j<m-s;j++){
                int csum=p[i+s][j+s];
                if(j-1>=0) csum-=p[i+s][j-1];
                if(i-1>=0) csum-=p[i-1][j+s];
                if(i-1>=0 && j-1>=0) csum+=p[i-1][j-1];
                if(csum<=t) return true;
            }
        }
        return false;
    }
    int [][] prefix(int a[][],int n,int m){
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=a[i][j];
                if(i-1>=0) dp[i][j]+=dp[i-1][j];
                if(j-1>=0) dp[i][j]+=dp[i][j-1];
                if(i-1>=0 && j-1>=0) dp[i][j]-=dp[i-1][j-1];
            }
        }
        return dp;
    }
}