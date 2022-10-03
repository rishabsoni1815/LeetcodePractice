class Solution {
    public int[] xorQueries(int[] a, int[][] q) {
        int n=a.length;
        int pre[]=new int[n];
        pre[0]=a[0];
        for(int i=1;i<n;i++){
            pre[i]=a[i]^pre[i-1];
        }
        int ans[]=new int[q.length];
        for(int i=0;i<q.length;i++){
            ans[i]=pre[q[i][1]];
            if(q[i][0]-1>=0) ans[i]^=pre[q[i][0]-1];
        }
        return ans;
    }
}