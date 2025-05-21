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
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==0 || j==0){
                    if(i==0 && fRow) a[i][j]=0;
                    else if(j==0 && fCol) a[i][j]=0;
                }
                else if(a[0][j]==0 || a[i][0]==0) a[i][j]=0;
            }
        } 
    }
}