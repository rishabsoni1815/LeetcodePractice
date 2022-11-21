class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    boolean valid(int i,int j,int n,int m,char c[][]){
        if(i>=n||i<0||j<0||j>=m||c[i][j]=='+') return false;
        return true;
    }
    public int nearestExit(char[][] c, int[] e) {
        int n=c.length;
        int m=c[0].length;    
        Queue<Pair>q=new LinkedList<>();
        boolean v[][]=new boolean[n][m];
        q.add(new Pair(e[0],e[1]));
        int cc=0;
        int dirx[]={1,-1,0,0};
        v[e[0]][e[1]]=true;
        int diry[]={0,0,1,-1};
        while(!q.isEmpty()){
            int s=q.size();
            cc++;
            for(int ij=0;ij<s;ij++){
                Pair t=q.poll();
                int x=t.x;
                int y=t.y;
                for(int i=0;i<4;i++){
                    int xx=x+dirx[i];
                    int yy=y+diry[i];
                    if(valid(xx,yy,n,m,c)&&v[xx][yy]==false){
                        if((c[xx][yy]=='.')&&(xx==n-1||yy==m-1||xx==0||yy==0)) return cc;
                            v[xx][yy]=true;
                            q.add(new Pair(xx,yy));
                    }
                }
            }
        }
        return -1;
    }
}