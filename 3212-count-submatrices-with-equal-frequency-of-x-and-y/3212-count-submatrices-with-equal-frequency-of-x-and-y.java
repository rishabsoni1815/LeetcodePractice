class Solution {
    public int numberOfSubmatrices(char[][] a) {
        int n=a.length,m=a[0].length;
        int x[][]=new int[n][m];
        int y[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                x[i][j]=(a[i][j]=='X' ? 1:0);
                if(i-1>=0) x[i][j]+=x[i-1][j];
                if(j-1>=0) x[i][j]+=x[i][j-1];
                if(i-1>=0 && j-1>=0) x[i][j]-=x[i-1][j-1];
                y[i][j]=(a[i][j]=='Y' ? 1:0);
                if(i-1>=0) y[i][j]+=y[i-1][j];
                if(j-1>=0) y[i][j]+=y[i][j-1];
                if(i-1>=0 && j-1>=0) y[i][j]-=y[i-1][j-1];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int xc=x[i][j];
                int yc=y[i][j];
                if(xc>0 && xc==yc) ans++;
            }
        }
        return ans;
    }
}