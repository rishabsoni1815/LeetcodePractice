class Solution {
    public int countNegatives(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int ans=0,i=0,j=m-1;
        while(i<n){
            while(j>=0 && a[i][j]<0){
                j--;
            }
            ans+=(m-j-1);
            i++;
        }
        return ans;
    }
}