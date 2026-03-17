class Solution {
    public int largestSubmatrix(int[][] a) {
        int n=a.length,m=a[0].length;
        int s[]=new int[m];
        int ans=0;
        for(int i=0;i<n;i++){
            int x[]=new int[m];
            for(int j=0;j<m;j++){
                if(a[i][j]==1) s[j]+=a[i][j];
                else s[j]=0;
                x[j]=s[j];
            }
            Arrays.sort(x);
            for(int ii=m-1;ii>=0;ii--){
                ans=Math.max(ans,x[ii]*(m-ii));
            }
        }
        return ans;
    }
}
// 110
// 101
// 211