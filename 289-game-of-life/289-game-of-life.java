class Solution {
    public void gameOfLife(int[][] a) {
        //2-> a zero in future
        //3->a one in future
        int n=a.length;
        int m=a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int c=count(i,j,n,m,a);
                if(c<2 && a[i][j]==1) a[i][j]=2;
                else if((c==2 || c==3) && a[i][j]==1) a[i][j]=1;
                else if((c>3) && a[i][j]==1) a[i][j]=2;
                else if(c==3 && a[i][j]==0) a[i][j]=3;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(a[i][j]==2) a[i][j]=0;
               else if(a[i][j]==3) a[i][j]=1;
            }
        }
    }
    int count(int x,int y,int n,int m,int a[][]){
        int dirx[]={-1,-1,-1,0,1,1,1,0};int diry[]={-1,0,1,1,1,0,-1,-1};
        int c=0;//count of 1's
            for(int i=0;i<8;i++){
                int ii=x+dirx[i];
                int jj=y+diry[i];
                if(ii>=0&&ii<n&&jj<m&&jj>=0){
                    if(a[ii][jj]==1 || a[ii][jj]==2)c++;
                }
            }
        return c;
    }
}