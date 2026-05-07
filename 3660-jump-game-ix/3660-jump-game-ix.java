class Solution {

    record Item(int value, int left, int right) {}

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        List<Item> stack = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Item curr = new Item(nums[i], i, i);

            while (!stack.isEmpty() && stack.getLast().value() > nums[i]) {
                Item top = stack.removeLast();
                curr = new Item(
                    Math.max(curr.value(), top.value()),
                    top.left(),
                    curr.right()
                );
            }

            stack.add(curr);
        }

        for (int i = 0; i < stack.size(); i++) {
            for (int j = stack.get(i).left(); j <= stack.get(i).right(); j++) {
                ans[j] = stack.get(i).value();
            }
        }

        return ans;
    }
}