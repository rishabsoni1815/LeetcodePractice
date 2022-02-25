class Solution {
    /*

    Pick the middle column.
Find the global maximum in the column.
If the row-neighbours of this element are smaller, then we found a 2D peak. Else, we recurse at the right-half of the matrix if the right-neighbour was bigger, and left-half of the matrix if the left-neighbour was bigger.
Here is a little intuition as to why this works.

When we find a row-neighbour that is bigger than the global maximum of a column, it means that the row-neighbour is bigger than all the elements of that column. Thus, the global maximum of the neighbour's column must be bigger than its corresponding row-neighbour in our column.
    
    */
    public int[] findPeakGrid(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, lo = 0, hi = m - 1, mid; 
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int max_row = 0;
            for (int i = 0; i < n; ++i) {
                if (matrix[max_row][mid] < matrix[i][mid])
                    max_row = i;
            }
            if ((mid == 0 || matrix[max_row][mid] > matrix[max_row][mid - 1]) && 
                (mid == m - 1 || matrix[max_row][mid] > matrix[max_row][mid + 1]))
                return new int[] {max_row, mid};
            else if (mid > 0 && matrix[max_row][mid - 1] > matrix[max_row][mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return new int[] {-1, -1};
    }
}