class Solution {
    public boolean carPooling(int[][] trips, int capacity) {    
        int[] locs = new int[1001];
        int sum = 0;
        for (int[] trip: trips) {
            locs[trip[1]] += trip[0];
            // locs[trip[2]+1] -= trip[0];not as on end time the passenger on board has left
            // so if [2 1 5] and [3 5 7] then on x=5 there were 3 passenger not 5 as 2 one have left
            locs[trip[2]] -= trip[0];
        }
        for (int loc : locs) {
            sum += loc;
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
    /*
    
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> m = new TreeMap<>();//in iteration can iterate like array
        for (int[] t : trips) {
            m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
            m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
        }
        for (int v : m.values()) {
            capacity -= v;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
     */
}