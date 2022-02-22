class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        //observe it is like monotonic queue
        //remove till peek is less than a[i] else add a[i] is size of stack is less than k but we need to check if we still have enough elements left(size at last should be k) After we pop the last element from stack, we have stack.size() - 1 in the stack, there are A.size() - i can still be pushed. if stack.size() - 1 + A.size() - i >= k, we can pop the stack.(as if we still pop then at last we won't have k elements which is our requirement)
        Stack<Integer> stack = new Stack<>();//add index to stack for ease
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }
        return result;
    }
}