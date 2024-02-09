class Solution {
    public List<Integer> largestDivisibleSubset(int[] a) {
        int n=a.length;
        int dp[]=new int[n];
        Arrays.sort(a);//sorting so that when we see j<i , a[i]%a[j]==0 then for all a[k] k<j a[i]%a[k]==0 ans also if you thing dp if we can check a[i]%a[j]==0 || a[j]%a[i]==0 its not guarantee if a[j]%a[i]==0 if all answers till j also are divisible by a[i]..... so sort and check ,as now we are sure if a[i]%a[j]==0 then all answers till a[j] also divide a[i]
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