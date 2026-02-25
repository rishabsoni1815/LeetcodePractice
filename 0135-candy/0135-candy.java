class Solution {
    public int candy(int[] a) {
        int dp[]=new int[a.length];
        Arrays.fill(dp,1);
        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1]){
                dp[i]=dp[i-1]+1;
            }
        }

        for(int i=a.length-2;i>=0;i--){
            if(a[i]>a[i+1]){
                dp[i]=dp[i+1]+1;
            }
        }
        int cnt=0;
        for(int c:dp) cnt+=c;
        return cnt;
    }
}