class Solution {
    /*
   // o(nlogn) sol.
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    */
    
    // o(n) sol.
    public int majorityElement(int[] a) {
        //moores algo taking first elemnt as answer if found other than do -- as if a number is > n/2 present in array then after this process ( -=1 when != ans) count should be >=1 (think on this as max we can - is <n/2 as majority elemtn is present >n/2 times) at last recheck what we have found is correct or not
        int ans=a[0];
        int count=1;
        for(int i=1;i<a.length;i++){
            if(a[i]==ans){
                count++;
            }else{
                count--;
            }
            if(count==0){
                count=1;
                ans=a[i];
            }
        }
        int anscount=0;
        for(int i=0;i<a.length;i++){//rechecking
            if(a[i]==ans){
                anscount++;
            }
        }
        if(anscount>(a.length/2)){
            return ans;
        }
        return -1;
    }
}