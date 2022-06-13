class Solution {
    public int minimumTotal(List<List<Integer>> a) {
        int n=a.size();
        int amt=a.get(n-1).size();
        int dp[][]=new int[amt][amt];
        for(int i=amt-1;i>=0;i--){
            for(int j=a.get(i).size()-1;j>=0;j--){
                if(i==amt-1){
                    dp[i][j]=a.get(i).get(j);
                }else{
                    dp[i][j]=a.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}