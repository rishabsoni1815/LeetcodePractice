class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001]; //or use map
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            sum[nums[i]] += nums[i];// as in sorted order if we delete a[i] then a[i-1] is all delteted and the other occursnces of a[i] can also be taken
            max = Math.max(max,nums[i]);
        }
        for(int i = 2; i <=max; i++){// travelling in sorted order till maximum elelemnt in array
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        }
        return sum[max];
    }
}