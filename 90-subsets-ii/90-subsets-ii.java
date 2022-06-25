class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>t=new ArrayList<>();
        help(0,nums,ans,t);
        return ans;
    }
    void help(int i,int nums[],List<List<Integer>>ans,List<Integer>t){
        if(i>nums.length) return;
        ans.add(new ArrayList<>(t));
        for(int j=i;j<nums.length;j++){
            if((j==i) || (nums[j]!=nums[j-1])){
                t.add(nums[j]);
                help(j+1,nums,ans,t);
                t.remove(t.size()-1);
            }
        }
    }
}