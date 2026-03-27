class Solution {
    public boolean areSimilar(int[][] a, int k) {
        int n=a.length;
        int m=a[0].length;
        int na[][]=new int[n][m];
        k%=m;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(i%2!=0){
                int nj=(j+k)%m;
                na[i][nj]=a[i][j];
               }else{
                int nj=(j-k+m)%m;
                na[i][nj]=a[i][j];
               }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]!=na[i][j]) return false;
            }
        }
        return true;
    }
}