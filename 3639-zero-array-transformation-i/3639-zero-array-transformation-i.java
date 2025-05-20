class Solution {
    public boolean isZeroArray(int[] a, int[][] q) {
        int n=a.length;
        int p[]=new int[n+1];
        for(int i=0;i<q.length;i++){
            p[q[i][0]]-=1;
            p[q[i][1]+1]+=1;
        }
        for(int i=1;i<=n;i++){
            p[i]=p[i]+p[i-1];
        }
        for(int i=0;i<n;i++){
            if(a[i]+p[i]>0) return false;
        }
        return true;
    }
}