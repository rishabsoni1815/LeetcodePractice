class Solution {
    boolean is=false;
    public int closedIsland(int[][] a) {
        int n=a.length;
        int m=a[0].length,ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==0){
                    is=false;
                    help(i,j,a,n,m);
                    if(is==false) ans++;
                }
            }
        }
        return ans;
    }
    void help(int i,int j,int a[][],int n,int m){
        if(i<0||i>=n||j<0||j>=m){
            is=true;
            return;
        }
        if(a[i][j]!=0) return;
        a[i][j]=1;
        help(i+1,j,a,n,m);
        help(i-1,j,a,n,m);
        help(i,j+1,a,n,m);
        help(i,j-1,a,n,m);
    }
}