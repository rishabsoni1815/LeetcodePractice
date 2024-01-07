class Solution {
    public int numberOfArithmeticSlices(int[] a) {
        int n=a.length,ans=0;
        HashMap<Long,Integer>dp[]=new HashMap[n];//as diff can be neg so map and (-)-(-) csn exceed int so long 
        for(int i=0;i<n;i++){
            dp[i]=new HashMap<>();
            for(int j=0;j<i;j++){
                long d=(long)(a[i])-a[j];
                int prevCnt=dp[j].getOrDefault(d,0);
                int curCnt=dp[i].getOrDefault(d,0);
                dp[i].put(d,prevCnt+curCnt+1);
                ans+=prevCnt;//not curCnt as if my prevCnt is greater than 1 that means now my subsequence is atleast of length 3 
            }
        }
        return ans;
    }
}