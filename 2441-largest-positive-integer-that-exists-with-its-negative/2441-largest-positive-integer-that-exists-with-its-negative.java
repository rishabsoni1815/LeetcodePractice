class Solution {
    public int findMaxK(int[] nums) {
        int ans = -1; 

        // A set to store seen numbers
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) { 
            int absNum = Math.abs(num);

            // If the absolute value is greater than the current maximum and its negative counter part is seen
            if (absNum > ans && seen.contains(-num))
                ans = absNum; 
            seen.add(num); // Insert the current number into the set
        }

        return ans;
    }
}