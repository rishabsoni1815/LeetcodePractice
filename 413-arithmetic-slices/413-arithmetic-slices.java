class Solution {
    public int numberOfArithmeticSlices(int[] a) {
        int n=a.length;
        if(n<=2) return 0;
        int dp[]=new int[n];
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1];
            int c=1,diff=a[i]-a[i-1];
            for(int j=i;j>0;j--){
                if(a[j]-a[j-1] == diff) c++;
                else break;
            }
            if(c>=3) dp[i]+=(c-2);
        }
        return dp[n-1];
    }
}