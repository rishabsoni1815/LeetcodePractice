class Solution {
    public double champagneTower(int p, int r, int c) {
        double dp[]=new double[r+2];
        for(int i=0;i<=r;i++){
            double next[]=new double[r+2];
            for(int j=0;j<=i;j++){
                if(i==0){
                    dp[j]=p;
                    if(p>1){
                        next[j]+=((p-1)/2.0);
                        next[j+1]+=((p-1)/2.0);
                        dp[j]=1;
                    }
                }else{
                    if(dp[j]>1){
                        next[j]+=((dp[j]-1)/2.0);
                        next[j+1]+=((dp[j]-1)/2.0);
                        dp[j]=1;
                    }
                }
            }
            if(i==r) return dp[c];//as else dp will be modified with next and dp[c] will be next[c] on line 25
            dp=next;
        }
        return dp[c];
    }
}