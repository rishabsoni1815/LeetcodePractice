// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         we can't do this method (product of whole and res[i]=product/nums[i]) as nums[i] can be 0 so whole product will be 0 but res will be diff. so have to calculate diffrerntly
//         int pro=nums[0];
//         for(int i=1;i<nums.length;i++){
//             pre*=nums[i];
//         }
//         for(int i=0;i<nums.length;i++){
            
//         }
//     }   
// }

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}