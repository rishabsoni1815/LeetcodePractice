class Solution {
    //like -> https://leetcode.com/problems/subarray-sums-divisible-by-k/
    //  https://youtu.be/sHFB71qC4wE?t=2816
    public long countInterestingSubarrays(List<Integer> A, int mod, int k) {
        long res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        for (int a : A) {
            sum = (sum + (a % mod == k ? 1 : 0)) % mod;
            
            res += map.getOrDefault((sum - k + mod) % mod, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}