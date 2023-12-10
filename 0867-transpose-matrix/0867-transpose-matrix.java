class Solution {
    public int[][] transpose(int[][] a) {
        int n=a.length;int m=a[0].length;
        int ans[][]=new int[m][n];
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                ans[j][i]=a[i][j];
            }
        }
        return ans;
    }
}