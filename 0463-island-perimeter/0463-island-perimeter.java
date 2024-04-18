class Solution {
    public int islandPerimeter(int[][] a) {
        int ans=0,n=a.length,m=a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1) {
                    ans+=4;
                    if(i>0 && a[i-1][j]==1){
                        ans--;
                    }
                    if(j>0 && a[i][j-1]==1){
                        ans--;
                    }
                    if(i+1<n && a[i+1][j]==1){
                        ans--;
                    }
                    if(j+1<m && a[i][j+1]==1){
                        ans--;
                    }
                }
            }
        }
        return ans;
    }
}