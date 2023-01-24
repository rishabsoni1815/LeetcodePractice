class Solution {
    public int snakesAndLadders(int[][] board) {
         int n = board.length;
        int steps = 0;
      Queue<Integer> q = new LinkedList<Integer>();
      boolean visited[] = new boolean[n*n +1];
       q.add(1);
       visited[1] = true;
        while(q.size()>0){
            int size=q.size();
            steps++;
            for(int j=0;j<size;j++){
                int node=q.poll();
                if(node==n*n) return steps-1;
                for(int k=1;k<=6;k++){
                    if(k+node>(n*n)) break;
                    if(visited[node+k]==false){
                        visited[node+k]=true;
                         int value = getBoardValue(board, node+k);
                        if(value==-1) q.add(k+node);
                        else{
                            q.add(value);
                        }
                    }
                }
                
            }
        }
        return -1;
    }
    int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int oldRow = (num - 1) / n;
        int row = n-1 -oldRow;//as 1 is not in 0th row but in n-1th row
        int oldCol = (num-1) % n;
        int col = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;//for odd order is reverse
        
        return board[row][col];
    }
}