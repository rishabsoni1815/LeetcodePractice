class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] g) {
        return bfs(g,g.length,g[0].length);
    }
    int bfs(int g[][],int n,int m){
        Queue<Pair>q=new LinkedList<>();
        int freshoranges=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==2) q.add(new Pair(i,j));
                if(g[i][j]==1) freshoranges++;
            }
        }
        if(freshoranges==0) return 0;//imp as in last we are returning ans-1 so for 0 last line will return -1
        int ans=0;
        int dirx[]={1,-1,0,0};
        int diry[]={0,0,1,-1};
        while(q.isEmpty()==false){
            ans++;
            int size=q.size();
            for(int ii=0;ii<size;ii++){
                Pair t=q.poll();
                int x=t.i;
                int y=t.j;
                for(int ik=0;ik<4;ik++){
                    int xx=dirx[ik]+x;
                    int yy=diry[ik]+y;
                    if(xx>=0 && xx<n && yy>=0 && yy<m && g[xx][yy]==1){
                        g[xx][yy]=2;//update here only as other can also add the same else asuming neighbour is not visitied
                        freshoranges--;
                        q.add(new Pair(xx,yy));
                    }
                }
            }
        }
        return freshoranges==0?ans-1:-1;
    }
}