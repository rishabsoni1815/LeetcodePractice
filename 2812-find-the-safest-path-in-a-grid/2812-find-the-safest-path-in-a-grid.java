class Solution {
    int dx[]={1,-1,0,0};
    int dy[]={0,0,1,-1};
    public int maximumSafenessFactor(List<List<Integer>> g) {
        int n=g.size();
        int m=g.get(0).size();
        if(g.get(0).get(0)==1||g.get(n-1).get(m-1)==1) return 0;
        int dis[][]=new int[n][m];
        findDis(dis,g,n,m);
        int l=0,r=2*(n+m),ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(check(mid,dis,g,n,m)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    
    boolean check(int k,int dis[][],List<List<Integer>> g,int n,int m){
        Queue<int []>q=new LinkedList<>();    
        if(dis[0][0]<k || dis[n-1][m-1]<k) return false;
        q.add(new int[]{0,0});
        boolean v[][]=new boolean[n][m];
        v[0][0]=true;
        while(q.size()>0){
            int s=q.size();
            for(int j=0;j<s;j++){
                int c[]=q.poll();
                int pari=c[0],parj=c[1];
                if(pari==n-1 && parj==m-1) return true;
                for(int i=0;i<4;i++){
                    int nx=pari+dx[i];
                    int ny=parj+dy[i];
                    if(nx>=0 && nx<n && ny<m && ny>=0 && v[nx][ny]==false && g.get(nx).get(ny)==0 && dis[nx][ny]>=k){
                        v[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
    
    void findDis(int dis[][],List<List<Integer>>g,int n,int m){
        boolean v[][]=new boolean[n][m];
        Queue<int []>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g.get(i).get(j)==1) {
                    q.add(new int[]{i,j,0});
                    v[i][j]=true;
                }
            }
        }
        while(q.size()>0){
            int s=q.size();
            for(int j=0;j<s;j++){
                int c[]=q.poll();
                int pari=c[0],parj=c[1],cdis=c[2];
                for(int i=0;i<4;i++){
                    int nx=pari+dx[i];
                    int ny=parj+dy[i];
                    if(nx>=0 && nx<n && ny<m && ny>=0 && v[nx][ny]==false && g.get(nx).get(ny)==0){
                        v[nx][ny]=true;
                        dis[nx][ny]=cdis+1;
                        q.add(new int[]{nx,ny,cdis+1});
                    }
                }
            }
        }
    }
}