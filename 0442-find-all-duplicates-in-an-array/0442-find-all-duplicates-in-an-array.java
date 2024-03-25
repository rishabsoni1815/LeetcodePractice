class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int x=Math.abs(nums[i])-1;
            if(nums[x]<0){
                ans.add(x+1);
            }else{
                nums[x]*=-1;
            }
        }
        return ans;
    }
}