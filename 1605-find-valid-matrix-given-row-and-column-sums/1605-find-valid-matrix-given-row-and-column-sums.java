class Solution {
    public int[][] restoreMatrix(int[] r, int[] c) {
        int n=r.length,m=c.length;
        int a[][]=new int[n][m]; 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(r[i]<=c[j]){
                    a[i][j]=r[i];
                    c[j]-=r[i];
                    r[i]=0;
                }else{
                    a[i][j]=c[j];
                    r[i]-=c[j];
                    c[j]=0;
                }
            }
        }
        return a;
    }
}