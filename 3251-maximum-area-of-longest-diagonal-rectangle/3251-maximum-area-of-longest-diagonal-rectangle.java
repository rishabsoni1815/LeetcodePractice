class Solution {
    public int areaOfMaxDiagonal(int[][] a) {
        int n=a.length;
        int ans=0,dia=0;
        for(int i=0;i<n;i++){
            int s=a[i][0]*a[i][0] + a[i][1]*a[i][1];
            if(s>=dia){
                if(s==dia) ans=Math.max(ans,a[i][0]*a[i][1]);
                else ans=a[i][0]*a[i][1];
                dia=s;
            }
        }
        return ans;
    }
}