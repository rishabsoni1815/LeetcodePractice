class Solution {
    public int[][] generateMatrix(int n) {
        int a[][]=new int[n][n];
         int r=n;
        int c=n;
         int d=0;
        int ii=1;
       int left=0,right=c-1,up=0,down=r-1;
        // d=3 up, d=1 down, d=2 left , d=0 right
       while(ii<=(n*n)&&left<=right&&up<=down){
           if(d==3){
               for(int i=down;i>=up;i--,ii++){              
                   a[i][left]=ii;
               }
                  left++;
           }else if(d==1){
               for(int i=up;i<=down;i++,ii++){
                   a[i][right]=ii;
               }
                  right--;
           }
           else if(d==0){
               for(int i=left;i<=right;i++,ii++){
                   a[up][i]=ii;
               }
                  up++;
           }else if(d==2){
                 for(int i=right;i>=left;i--,ii++){
                     a[down][i]=ii;
               }
                  down--;
           }
           d=(d+1)%4;
       }
       return a;
    }
}