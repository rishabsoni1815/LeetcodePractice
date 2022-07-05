class Solution {
    public int minCost(int n, int[] a) {
        //if we sort then on left part there will be pos. less than a[i] so left and right part are independent
        int l=a.length;
        int c[]=new int[l+2];
        c[0]=0;
        c[l+1]=n;
        for(int i=1;i<=l;i++) c[i]=a[i-1];
        Arrays.sort(c);
        Integer dp[][]=new Integer[l+1][l+1];
        return help(1,l,c,dp);
    }
    int help(int i,int j,int c[],Integer dp[][]){
        if(i>j) return 0;
        int min=Integer.MAX_VALUE;
        if(dp[i][j]!=null) return dp[i][j];
        for(int k=i;k<=j;k++){
            min=Math.min(min,c[j+1]-c[i-1]+help(i,k-1,c,dp)+help(k+1,j,c,dp));
        }
        return dp[i][j]=min;
    }
}