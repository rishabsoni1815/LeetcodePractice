class Solution {
    public List<Integer> largestDivisibleSubset(int[] a) {
        int n=a.length;
        int dp[]=new int[n];
        Arrays.sort(a);
        int ans=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(a[i]%a[j] == 0){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        Stack<Integer>s=new Stack<>();
        int prev=-1;
        for(int i=n-1;i>=0;i--){
            if(dp[i]==ans){
                if(prev==-1 || prev%a[i]==0) {
                    s.add(a[i]);
                    prev=a[i];
                    ans--;
                }
            }
        }
        List<Integer>ansL=new ArrayList<>();
        while(s.size()>0) ansL.add(s.pop());
        return ansL;
    }
}