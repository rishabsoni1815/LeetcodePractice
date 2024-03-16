public class Solution {
    public int findMaxLength(int[] nums) {
        // if we add 1 and subtract 1 when 0 then it is like finding longest subarray with sum as 0
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);// use a test case
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
