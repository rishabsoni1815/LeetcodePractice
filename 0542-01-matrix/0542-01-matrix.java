public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
         //dont do check form each cell with 1 and check which is min distance of 1 from it instead do multisouce bfs from all the cells with 0 in them and initialise all 1s with int_max
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    count++;
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || 
                        matrix[r][c] != Integer.MAX_VALUE) continue;
                    queue.add(new int[] {r, c});
                    matrix[r][c] = dist;
                    count--;
                    if(count == 0) return matrix;
                }
            }

        }
        
        return matrix;
    }
}
