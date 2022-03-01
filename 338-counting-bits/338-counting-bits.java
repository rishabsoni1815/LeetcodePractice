class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        if(n>=1) ans[1]=1;
        int x=2;
        for(int i=2;i<=n;i++){
            ans[i]=ans[i-x]+1;
            if(i==(2*x-1)) x*=2;
        }
        return ans;
    }
}