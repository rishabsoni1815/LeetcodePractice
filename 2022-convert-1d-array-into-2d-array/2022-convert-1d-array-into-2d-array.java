class Solution {
    public int[][] construct2DArray(int[] a, int n, int m) {
        if(a.length>(n*m) || a.length<(n*m)) return new int[0][0];
        
        int ans[][]=new int[n][m];
        for(int i=0;i<n*m;i++){
            int j=(i)/m;
            int k=i%m;
            ans[j][k]=a[i];
        }
        return ans;
    }
}