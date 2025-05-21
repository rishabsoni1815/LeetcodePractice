class Solution {
    public void setZeroes(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        boolean fRow=false;
        boolean fCol=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0) && a[i][j]==0){
                    if(j==0) fCol=true;
                    if(i==0) fRow=true;
                }else{
                    if(a[i][j]==0){
                        a[0][j]=0;
                        a[i][0]=0;
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(a[0][j]==0 || a[i][0]==0) a[i][j]=0;
            }
        }
        if(fCol) for(int i=0;i<n;i++) a[i][0]=0;
        if(fRow) for(int i=0;i<m;i++) a[0][i]=0;   
    }
}