class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> h = new HashMap<>();
        int ans = 0;

        for (int num: nums) {
            ans += h.getOrDefault(num, 0);
            h.put(num, h.getOrDefault(num, 0) + 1);
        }
        
        return ans;
    }
}