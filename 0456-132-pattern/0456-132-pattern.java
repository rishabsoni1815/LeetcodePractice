public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) min[i] = Math.min(
            min[i - 1],
            nums[i]
        );
        for (int j = nums.length - 1; j >= 0; j--) {
            //we have min as 1 now 3 we are iterating (a[j]) from right to left now only need elements which are btw 1 and 3 so only keeping ele which are > 1 and which ever comes first ele which is greater than 1 and less than 3 that's the ans so stack will have ele in order are they appear in array from right to left but all will be >1 and when ge get any which is >1 and <3 (a[j]) we return

            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j]) return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}