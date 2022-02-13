class Solution {
    public int minMoves2(int[] nums) {
        // the number for which all i's should be is median of the array as ->
        // If you observe, once all the numbers are sorted, the minimum moves required to make all array elements equal is by moving up, i.e. increasing the numbers from the left end and moving down, i.e. decreasing the numbers from the right end until all the numbers become equal. You will notice that all the numbers become equal mid-way. Hence, the intuition is that you must make all numbers equal to the middle number in the sorted array for the minimum number of moves. Hence, the absolute difference of the current number and the middle number is the number of moves required for this number. The sum of absolute difference for all the numbers is your answer.
        
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        Arrays.sort (nums);
        int mid = n/2;
        int count = 0;
        for (int i = 0; i < n; i++)
            count += (Math.abs (nums [i] - nums [mid]));
        return count;
        
    }
}