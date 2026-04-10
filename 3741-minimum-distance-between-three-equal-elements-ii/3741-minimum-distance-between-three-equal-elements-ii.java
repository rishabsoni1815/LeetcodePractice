class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Store all indices for each number
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Check each list of indices
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue; // Need at least 3 occurrences

            // Compute distance for first triplet
            int id1 = list.get(0), id2 = list.get(1), id3 = list.get(2);
            ans = Math.min(ans, Math.abs(id1 - id2) + Math.abs(id2 - id3) + Math.abs(id3 - id1));

            // Slide the window of size 3 across the list
            for (int i = 3; i < list.size(); i++) {
                id1 = id2;
                id2 = id3;
                id3 = list.get(i);
                ans = Math.min(ans, Math.abs(id1 - id2) + Math.abs(id2 - id3) + Math.abs(id3 - id1));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans; // No valid triplet found
    }
}