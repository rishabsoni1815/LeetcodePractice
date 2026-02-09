class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {//dp ccant be applied ans subproblems depend on other subproblems so we apply dijkstra with distance as the key for min heap
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];//dis from 0,0 to i,j
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x,y)->(x[0]-y[0]));//min heap
        minHeap.offer(new int[]{0, 0, 0}); // distance, row, col
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int d = top[0], r = top[1], c = top[2];
            if (d > dist[r][c]) continue;//since on line 18 this will be max and line 19 will be false so why che k all this
            if (r == m - 1 && c == n - 1) return d; // Reach to bottom right
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i], nc = c + DIR[i + 1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));//as we need max dis btw 2 during total path
                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;
                        minHeap.offer(new int[]{dist[nr][nc], nr, nc});
                    }
                }
            }
        }
        return 0; // Unreachable code, Java require to return interger value.
    }
}