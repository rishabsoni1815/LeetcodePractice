class Solution {
    public int minOperations(int[][] grid, int x) {
        // the number for which all i's should be is median of the array as ->
        // If you observe, once all the numbers are sorted, the minimum moves required to make all array elements equal is by moving up, i.e. increasing the numbers from the left end and moving down, i.e. decreasing the numbers from the right end until all the numbers become equal. You will notice that all the numbers become equal mid-way. Hence, the intuition is that you must make all numbers equal to the middle number in the sorted array for the minimum number of moves. Hence, the absolute difference of the current number and the middle number is the number of moves required for this number. The sum of absolute difference for all the numbers is your answer. if abs diff is not divisible by x that means we can's make the number as median by add or subtract x as diff is not divisible by x so then return -1
        ArrayList<Integer> arr = new ArrayList<>();
        int m = grid.length,n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int median = arr.get((arr.size())/2);
        int count = 0;
        for(int val : arr){
            int diff = Math.abs(val-median);
            if(diff % x!=0) return -1;
            count += diff / x;   
        }
        return count;
    }
}