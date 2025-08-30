class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];//i,j tells if j is already seen in ith row or not
        boolean[][] cols = new boolean[9][9];//i,j tells if j is already seen in ith col or not
        boolean[][] boxes = new boolean[9][9];//i,j tells if j is already seen in ith box or not 

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;
                }
            }
        }
        return true;
    }
}