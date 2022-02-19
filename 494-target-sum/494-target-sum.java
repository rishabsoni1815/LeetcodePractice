class Solution {
    public int findTargetSumWays(int[] a, int k) {
        int n=a.length;
        int sum=0;
        int c=0;
        for(int y:a) {
            sum+=y;
         if(y==0) c++;   
        }
        int ans=0;
        if(k>sum||(sum+k)%2!=0) return 0;
        k=((sum+k)/2);
        if(k<0) return 0;
        int t[][]=new int[n+1][k+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=k; j++) {
               if(i==0&&j==0){
                   t[i][j]=1;
               }
                else if(j==0&&i!=0){
                    t[i][j]=1;
                }else if(i==0&&j!=0){
                    t[i][j]=0;
                }
                else if (a[i-1] > j||a[i-1]==0) {
                    t[i][j] = t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j]+ t[i-1][j-(a[i-1])];;
                }                   
             }
         }
        return (int)Math.pow(2,c)*t[n][k];
    }
}