class Solution {
    int dirx[]={1,-1,0,0};
    int diry[]={0,0,1,-1};
    public int[][] updateMatrix(int[][] a) {
        int n=a.length,m=a[0].length;
        Queue<int []>q=new LinkedList<>();
        boolean v[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==0){
                    v[i][j]=true;
                    q.add(new int[]{i,j});
                }else{
                    a[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int ans=0;
        while(q.size()>0){
            ans++;
            int s=q.size();
            for(int i=0;i<s;i++){
                int c[]=q.poll();
                for(int j=0;j<4;j++){
                    int nx=c[0]+dirx[j];
                    int ny=c[1]+diry[j];
                    if(nx>=0 && nx<n && ny>=0 && ny<m){
                        if(a[nx][ny]!=0){
                            a[nx][ny]=Math.min(a[nx][ny],ans);
                        }
                        if(v[nx][ny]==false) q.add(new int[]{nx,ny});
                        v[nx][ny]=true;
                    }
                }
            }
        }
        return a;
    }
}