class Solution {
    public List<Integer> largestDivisibleSubset(int[] a) {
        int n=a.length;
        Arrays.sort(a);//sorting so that when we see j<i , a[i]%a[j]==0 then for all a[k] k<j a[i]%a[k]==0
        int max=0;
        int dp[]=new int[n];
    int[] prev = new int[n]; // the previous index of element i in the largestDivisibleSubset ends with element i
    int index = -1;//to backtrack
        for(int i=0;i<n;i++){
            dp[i]=1;
            prev[i]=-1;//so that we can stop
            for(int j=0;j<i;j++){
                if(a[i]%a[j]==0 && dp[j]+1>dp[i]) {
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                index=i;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
    while (index != -1){
        res.add(a[index]);
        index = prev[index];
    }
    return res;
    }
}