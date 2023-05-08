class Solution {
    public int diagonalSum(int[][] a) {
        int n=a.length;
        int j=0,sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i][j];
            j++;
        }
        j=n-1;
        for(int i=0;i<n;i++){
            sum+=a[i][j];
            j--;
        }
        if(n%2==0) return sum;
        return sum-a[n/2][n/2];
    }
}