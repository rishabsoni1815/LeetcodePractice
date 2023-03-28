class Solution {
    public int mincostTickets(int[] d, int[] c) {
        int n=c.length;
        int amt=d[d.length-1];
        HashSet<Integer>h=new HashSet<>();
        for(int v:d) h.add(v);
        int dp[]=new int[amt+1];
        for(int i=1;i<=amt;i++){
            dp[i]=dp[i-1];
            int yy=Integer.MAX_VALUE;
            if(h.contains(i)){
                 yy=Math.min(yy,c[0]+(i-1>=0?dp[i-1]:0));
                 yy=Math.min(yy,c[1]+(i-7>=0?dp[i-7]:0));
                 yy=Math.min(yy,c[2]+(i-30>=0?dp[i-30]:0));
                dp[i]=yy;
            }
        }
        return dp[amt];
    }
}