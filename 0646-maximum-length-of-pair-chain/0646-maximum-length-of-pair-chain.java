class Solution {
    public int findLongestChain(int[][] a) {
        int n=a.length;
        Arrays.sort(a,(x,y)->(x[1]-y[1]));
        int min=Integer.MIN_VALUE,ans=0,i=0;
        while(i<n){
            if(a[i][0]>min){
                min=a[i][1];
                ans++;
            }
            i++;
        }
        return ans;
    }
    
    
   /* 
    public int findLongestChain(int[][] a) {
        int n=a.length;
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(a[j][0]>a[i][1]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
   */
}