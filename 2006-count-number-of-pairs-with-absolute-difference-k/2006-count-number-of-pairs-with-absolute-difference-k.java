class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0;i< nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int num:map.keySet()){
           if(map.containsKey(num-k)){
               res+=(map.get(num)*(map.get(num-k)));
           }
           if(map.containsKey(num+k)){
               res+=(map.get(num)*(map.get(num+k)));
           }
        } 
        return res/2;
    }
}