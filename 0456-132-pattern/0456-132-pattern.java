public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        TreeSet<Integer> set = new TreeSet<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) min[i] = Math.min(
            min[i - 1],
            nums[i]
        );
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                Integer cur=set.higher(min[j]);
                if(cur!=null && cur<nums[j]) return true;
                set.add(nums[j]);
            }
        }
        return false;
    }
}