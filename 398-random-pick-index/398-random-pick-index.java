class Solution {
    Random rand;
    HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
    public Solution(int[] nums) {
        map=new HashMap<>();
        rand = new Random();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                map.put(nums[i],new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }
    }
    
    public int pick(int target) {
        int max=map.get(target).size();
        // rand.nextInt(max) this generates random nos from 0 to max-1 => [0,max)
        return map.get(target).get(rand.nextInt(max));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */