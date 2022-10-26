class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(k==0){
            return nums.length>1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        map.put(0,-1);
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            runningSum %= k; 
            if(map.containsKey(runningSum)){
                if(i-map.get(runningSum)>1){
                    return true;
                }
            }
            else map.put(runningSum,i);
        }
        return false;
    }
}