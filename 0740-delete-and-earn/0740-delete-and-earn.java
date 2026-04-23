class Solution {
    public int deleteAndEarn(int[] c) {
        ArrayList<Integer>a=new ArrayList<>();
        HashMap<Integer,Integer>h=new HashMap<>();
        int n=c.length;
        for(int i=0;i<n;i++){
            if(h.containsKey(c[i])==false) a.add(c[i]);
            h.put(c[i],h.getOrDefault(c[i],0)+c[i]);
        }
        Collections.sort(a);
        int dp[]=new int[a.size()];
        System.out.println(h);
        dp[0]=h.get(a.get(0));
        int ans=dp[0];
        for(int i=1;i<dp.length;i++){
            dp[i]=h.get(a.get(i));
            if(i-1>=0 && a.get(i)!=(a.get(i-1)+1)) dp[i]+=dp[i-1];
            else if(i-2>=0) dp[i]+=dp[i-2];
            dp[i]=Math.max(dp[i-1],dp[i]);
            ans=Math.max(ans,dp[i]);
            // System.out.println(a.get(i)+" "+dp[i]+" "+dp[i-1]);
        }
        return ans;
    }
}