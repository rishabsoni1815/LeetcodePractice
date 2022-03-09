class Solution {
    public int maxArea(int ht, int wt, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);
        int mod=(int)(1e9 + 7);
        long maxh=(h[0]-0)%mod;
        long maxv=(v[0]-0)%mod;
        int n=h.length;int m=v.length;
        for(int i=1;i<n;i++) maxh=Math.max(maxh,(h[i]-h[i-1]+mod)%mod);
        maxh=Math.max(maxh,(ht-h[n-1]+mod)%mod);
        for(int i=1;i<m;i++) maxv=Math.max(maxv,(v[i]-v[i-1]+mod)%mod);
        maxv=Math.max(maxv,(wt-v[m-1]+mod)%mod);
        return (int)(maxh%mod*maxv%mod)%mod;
    }
}