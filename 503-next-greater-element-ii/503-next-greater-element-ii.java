public class Solution {
//o(n)
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();//like concatinate array with its copy to reduce space can do below else brute can be to apply on 2*n array size
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }//this loop in total will nun only for n so overall complexity of problem is O(2n+2n) not O(n^2)
            if(i<nums.length) res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i%nums.length]);
        }
        return res;
    }
}