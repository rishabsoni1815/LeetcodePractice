class Solution {
    public int minFallingPathSum(int[][] a) {
        // to optimise we can see that min from next row is same for every element and will be second min. for the elemnt with same col. as min. as they have tld that no two elements chosen in adjacent rows are in the same column.
        
        int n=a.length;
        int dp[][]=new int[n][n];
        int min=Integer.MAX_VALUE,smin=Integer.MAX_VALUE,mini=-1;
        for(int i=0;i<n;i++){
            dp[n-1][i]=a[n-1][i];
            if(dp[n-1][i]<=min){
                smin=min;
                min=dp[n-1][i];
                mini=i;
                continue;
            }else if(dp[n-1][i]<smin){
                smin=dp[n-1][i];
            }
        }
        // System.out.println(min+" "+smin+" "+mini);
        for(int i=n-2;i>=0;i--){
            int amin=Integer.MAX_VALUE,asmin=Integer.MAX_VALUE,amini=-1;
            for(int j=n-1;j>=0;j--){
                if(j!=mini){
                    dp[i][j]=a[i][j]+min;
                }else{
                    dp[i][j]=a[i][j]+smin;
                }
                if(dp[i][j]<=amin){
                    asmin=amin;
                    amin=dp[i][j];
                    amini=j;
                    continue;
                }else if(dp[i][j]<asmin){
                    asmin=dp[i][j];
                }
            }
            min=amin;smin=asmin;mini=amini;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[0][i]);
        }
        return ans;
        
        
        
        // as paint house-2
        
        // int n=a.length;
        // int dp[][]=new int[n][n];
        // for(int i=n-1;i>=0;i--){
        //     for(int j=n-1;j>=0;j--){
        //         if(i==n-1){
        //             dp[i][j]=a[i][j];
        //             continue;
        //         }
        //         dp[i][j]=Integer.MAX_VALUE;
        //         for(int k=0;k<n;k++){
        //             if(k!=j) dp[i][j]=Math.min(dp[i][j],a[i][j]+dp[i+1][k]);
        //         }
        //     }
        // }
        // int min=Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //     min=Math.min(min,dp[0][i]);
        // }
        // return min;
    }
}