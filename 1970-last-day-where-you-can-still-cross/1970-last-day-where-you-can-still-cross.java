class Solution {
    public int latestDayToCross(int r, int c, int[][] a) {
        int ans=0,n=a.length;
        int l=0,ri=n-1;
        while(l<=ri){
            int m=(l+(ri-l)/2);
            if(help(m,a,r,c)){
                ans=m;
                l=m+1;
            }else{
                ri=m-1;
            }
        }
        return ans+1;
    }
    boolean help(int day, int[][] cells, int r, int c) {
        int total = r * c;
        int TOP = total;
        int BOTTOM = total + 1;

        DSU dsu = new DSU(total + 2);

        boolean[][] water = new boolean[r][c];

        // mark flooded cells till "day"
        for (int i = 0; i <= day; i++) {
            water[cells[i][0] - 1][cells[i][1] - 1] = true;
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        // connect land cells
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (water[i][j]) continue;

                int id = i * c + j;

                // connect top row to TOP
                if (i == 0) {
                    dsu.add(id, TOP);
                }

                // connect bottom row to BOTTOM
                if (i == r - 1) {
                    dsu.add(id, BOTTOM);
                }

                // connect neighbors
                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && ni < r && nj >= 0 && nj < c && !water[ni][nj]) {
                        int nid = ni * c + nj;
                        dsu.add(id, nid);
                    }
                }
            }
        }
        return dsu.findParent(TOP) == dsu.findParent(BOTTOM);
    }

    class DSU{
        int p[];
        int n;
        int r[];
        DSU(int n){
            this.n=n;
            p=new int[n];
            for(int i=0;i<n;i++){
                p[i]=i;
            }
            r=new int[n];
            Arrays.fill(r,1);
        }

        int findParent(int i){
            if(i==p[i]) return i;
            return p[i]=findParent(p[i]);
        }

        boolean add(int i,int j){
            int p1=findParent(i);
            int p2=findParent(j);
            if(p1==p2) return false;
            if(r[p1]>r[p2]){
                p[p2]=p1;
            }else if(r[p2]>r[p1]){
                p[p1]=p2;
            }else{
                p[p1]=p2;
                r[p2]++;
            }
            return true;
        }
    }
}