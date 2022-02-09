public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    /*
    //one pass
    
    class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            if (map.containsKey(i)) {
                if (k == 0 && map.get(i) == 1) {
                    result++;
                }
                map.put(i, map.get(i) + 1);
            } else {
                if (map.containsKey(i - k)) {
                    result++;
                }
                if (map.containsKey(i + k)) {
                    result++;
                }
                map.put(i, 1);
            }
        }
        return result;
    }
}
    
    
    */
}