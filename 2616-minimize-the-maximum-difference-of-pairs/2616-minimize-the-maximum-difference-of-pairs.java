class Solution {
    public int minimizeMax(int[] a, int p) {
        if(p==0) return 0;
        int n=a.length;
        Arrays.sort(a);
        int l=0,r=a[n-1]-a[0],ans=r;
        while(l<=r){
            int m=l+(r-l)/2;
            if(help(m,p,a)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
        
        
        // Integer dp[][]=new Integer[n+1][p+1];
        // return help(0,a,p,dp);
    }
    
    boolean help(int m,int p,int a[]){//are there p pairs with max diff as m
        int prev=0;
        for(int i=1;i<a.length;i++){
            if(a[i]-a[i-1]<=m){
                p--;
                i++;//imp
            }
            if(p==0) return true;
        }
        return false;
    }
    
    //mle o(n*p)
    int help(int i,int a[],int p,Integer dp[][]){
        if(p<=0) return Integer.MIN_VALUE;
        if(i>=a.length) return Integer.MAX_VALUE;
        if(dp[i][p]!=null) return dp[i][p];
        int min=help(i+1,a,p,dp);
        if(i<a.length-1) min=Math.min(min,Math.max(a[i+1]-a[i],help(i+2,a,p-1,dp)));
        return dp[i][p]=min;
    }
}