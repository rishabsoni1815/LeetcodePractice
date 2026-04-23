class Solution {

    /* 
    
    We first go left-to-right, and for each number we track:

sum of indexes
cnt of indexes
The resulting value for element n[i] is cnt[n[i]] * i - sum[n[i]].

Then, we repeat the same going right-to-left.
    
    */
    public long[] distance(int[] nums) {
        int n = nums.length;
        long res[] = new long[n];
        HashMap<Integer, Long> cnt_l = new HashMap<>();
        HashMap<Integer, Long> cnt_r = new HashMap<>();
        HashMap<Integer, Long> sum_l = new HashMap<>();
        HashMap<Integer, Long> sum_r = new HashMap<>();

        for (int i = 0; i < n; i++) {
            res[i] += cnt_l.getOrDefault(nums[i], 0l) * i - sum_l.getOrDefault(nums[i], 0l);
            cnt_l.put(nums[i], cnt_l.getOrDefault(nums[i], 0l) + 1);
            sum_l.put(nums[i], sum_l.getOrDefault(nums[i], 0l) + i);
        }
        for (int i = n - 1; i >= 0; i--) {
            res[i] += sum_r.getOrDefault(nums[i], 0l) - cnt_r.getOrDefault(nums[i], 0l) * i;
            cnt_r.put(nums[i], cnt_r.getOrDefault(nums[i], 0l) + 1);
            sum_r.put(nums[i], sum_r.getOrDefault(nums[i], 0l) + i);

        }
        return res;
    }
}