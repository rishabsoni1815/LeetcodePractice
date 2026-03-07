class Solution {
    public int minFlips(String s) {
        // Create a doubled string to explore all circular combinations
        String t = s + s;
        
        // Initialize variables for the sliding window and differences
        int left = 0; // Left pointer of the window
        int diff1 = 0; // Differences from Resultant String 1
        int diff2 = 0; // Differences from Resultant String 2
        int min = Integer.MAX_VALUE; // Initialize min to a large value
        
        // Iterate through the characters of the doubled string t
        for (int right = 0; right < t.length(); right++) {
            char rightChar = t.charAt(right);
            
            // Check if the right character at even index should be '0' and at odd index should be '1'
            if ((right % 2 == 0 && rightChar != '0') || (right % 2 != 0 && rightChar != '1')) {
                diff1++; // Increment differences for Resultant String 1
            }

            // Check if the right character at even index should be '1' and at odd index should be '0'
            if ((right % 2 == 0 && rightChar != '1') || (right % 2 != 0 && rightChar != '0')) {
                diff2++; // Increment differences for Resultant String 2
            }

            // Check if the sliding window size is equal to the length of the original string s
            if (right - left + 1 >= s.length()) {
                // Update min with the minimum of diff1 and diff2
                min = Integer.min(min, Math.min(diff1, diff2));
                
                // Move the left pointer, and update differences for the character that leaves the window
                char leftChar = t.charAt(left);
                if ((left % 2 == 0 && leftChar != '0') || (left % 2 != 0 && leftChar != '1')) {
                    diff1--;
                }
                if ((left % 2 == 0 && leftChar != '1') || (left % 2 != 0 && leftChar != '0')) {
                    diff2--;
                }
                left++; // Increment the left pointer to slide the window
            }
        }
        
        return min; // Return the minimum number of Type-2 operations
    }
}