class Solution {
    
    private int MIN_VALUE = Integer.MIN_VALUE;
    
    List<List<Integer>> result = new ArrayList<>();    
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        solve(nums, new ArrayList<>(), 0, MIN_VALUE);
        return result;
    }

    private void solve(int[] nums, ArrayList<Integer> list, int index, int previous){
        if(index == nums.length){
            if(list.size() > 1) result.add(new ArrayList<>(list));
            return;
        }
        
        //add element if greater
        if(nums[index] >= previous){
            list.add(nums[index]);
            solve(nums, list, index + 1, nums[index]);
            list.remove(list.size() - 1);
        }
        
        //If we find any duplicate value, we simply return.
        if(nums[index] == previous) return;
        
        //dont Add
        solve(nums, list, index + 1, previous);
         
    }   
}