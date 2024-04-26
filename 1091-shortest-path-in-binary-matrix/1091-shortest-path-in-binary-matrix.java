class Solution {
    int dirx[]={1,1,1,-1,-1,-1,0,0};
    int diry[]={0,1,-1,0,1,-1,1,-1};
    public int shortestPathBinaryMatrix(int[][] a) {
        int n=a.length,m=a[0].length;
        if(a[0][0]==1 || a[n-1][m-1]==1) return -1;
        Queue<int []>q=new LinkedList<>();
        q.add(new int[]{0,0});
        int ans=0;
        a[0][0]=1;
        while(q.size()>0){
            ans++;
            int ss=q.size();
            for(int j=0;j<ss;j++){
                int c[]=q.poll();
                if(c[0]==n-1 && c[1]==m-1) return ans;
                for(int i=0;i<8;i++){
                    int nx=c[0]+dirx[i];
                    int ny=c[1]+diry[i];
                    if(nx >=0 && ny>=0 && nx<n && ny<m && a[nx][ny]==0){
                        a[nx][ny]=1;
                        q.add(new int[]{nx,ny});
                    }
                }   
            }
        }
        return -1;
    }
}