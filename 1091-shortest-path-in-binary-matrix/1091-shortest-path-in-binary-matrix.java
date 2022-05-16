class Solution {
    public int shortestPathBinaryMatrix(int[][] a) {
        int n=a.length;
        int dirx[]={0,0,1,-1,1,1,-1,-1};
        int diry[]={-1,1,0,0,-1,1,-1,1};
        Queue<int []>q=new LinkedList<>();
        boolean v[][]=new boolean [n][n];
        if(a[0][0]==1||a[n-1][n-1]==1) return -1;
        if(n-1==0&&a[0][0]==0) return 1;
        q.add(new int[]{0,0});
        v[0][0]=true;
        int ans=1;
        while(q.size()>0){
            int s=q.size();
            ans++;
            while(s-->0){
                int t[]=q.poll();
                for(int i=0;i<8;i++){
                    int x=dirx[i]+t[0];
                    int y=diry[i]+t[1];
                    if(x>=0&&y>=0&&x<n&&y<n&&a[x][y]!=1&&v[x][y]==false){
                        if(x==n-1&&y==n-1) {
                            return ans;
                        }
                        q.add(new int[]{x,y});
                        v[x][y]=true;
                    }
                }
            }
        }
        return -1;
    }
}