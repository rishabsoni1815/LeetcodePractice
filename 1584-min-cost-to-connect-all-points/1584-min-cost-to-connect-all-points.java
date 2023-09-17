class Pair {
    int node;
    int distance;
    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] p) {
        return spanningTree(p,p.length);
    }
     static int spanningTree(int p[][],int n) {//prims add an node and then add closest of all its neighbour and keep on repeating -> https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=45
        PriorityQueue<Pair> pq =
            new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] vis = new int[n];
        // {wt, node}
        pq.add(new Pair(0, 0));
        int sum = 0;
        while (pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            int nx=p[node][0];
            int ny=p[node][1];
            pq.remove();

            if (vis[node] == 1) continue;
            // add it to the mst
            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < n; i++) {
                if (vis[i] == 0) {
                    int edW = findDist(nx,ny,p[i][0],p[i][1]);
                    pq.add(new Pair(edW, i));
                }
            }
        }
        return sum;
    }
   static int findDist(int x,int y, int a, int b) {
        return Math.abs(x - a) + Math.abs(y - b);
    }
}