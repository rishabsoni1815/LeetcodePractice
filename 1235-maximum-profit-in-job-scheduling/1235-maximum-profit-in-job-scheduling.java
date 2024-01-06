class Solution {
    public int jobScheduling(int[] s, int[] e, int[] p) {
        //https://www.youtube.com/watch?v=Uz2iNhjGGm0
        int n=s.length;
        int a[][]=new int[n][3];
        for(int i=0;i<n;i++){
            a[i][0]=s[i];
            a[i][1]=e[i];
            a[i][2]=p[i];
        }
        Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));

        int dp[]=new int[n];
        int max=0;
        for(int i=n-1;i>=0;i--){
            dp[i]=a[i][2];
            int x=bs(a[i][1],a,i+1);
            if(x!=-1){
                dp[i]=Math.max(dp[i],a[i][2]+dp[x]);
            }
            if(i!=n-1) dp[i]=Math.max(dp[i],dp[i+1]);// all test cases gets cover as we take binary search founded as well as just next as binary search founded has also done the same(excluded n taken its bs founded)
            max=Math.max(dp[i],max);
        }
        return max;
    }
    int bs(int x,int a[][],int l){
        int ans=-1,r=a.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m][0]>=x){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
}