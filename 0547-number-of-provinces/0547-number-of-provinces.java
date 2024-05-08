class Solution {
    public int findCircleNum(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        DisjointSet dsu = new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j&&a[i][j]==1){
                    dsu.union(i,j);
                }
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(dsu.p[i]==i) {
                c++;
            }
        }
        return c;
    }
    class DisjointSet{
        int p[];
        int r[];
        public DisjointSet(int n){
            p=new int[n];
            for(int i=0;i<n;i++) p[i]=i;
            r=new int[n];
        }
        public int findParent(int u){
            if(u==p[u]) return u;
            return p[u]=findParent(p[u]);
        }
        public boolean union(int u,int v){
            int p1=findParent(u);
            int p2=findParent(v);
            if(p1==p2) return false;//dont directly check using p[p1] and p[p2] instead use findParent as we want ultimate parent not just current parent
            if(r[p1]<r[p2]){
                p[p1]=p2;
            }else if(r[p1]>r[p2]){
                p[p2]=p1;
            }else{
                p[p2]=p1;
                r[p1]++;
            }
            return true;
        }
    }
}