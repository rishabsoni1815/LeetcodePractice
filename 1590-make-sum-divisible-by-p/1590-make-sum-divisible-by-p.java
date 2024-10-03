class Solution {
    public int minSubarray(int[] a, int p) {
        int n=a.length,sum=0;
        for(int i=0;i<n;i++){
            sum=(sum+a[i])%p;
        }
        sum%=p;
        if(sum==0) return 0;
        return smallestSubarrayOfSumK(a,sum,p);
    }
    int smallestSubarrayOfSumK(int nums[],int target,int p){
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // To handle the case where the whole prefix is the answer
        int currentSum = 0;
        int n = nums.length,minLen=n;

        // Step 3: Iterate over the array
        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;

            // Calculate what we need to remove
            int needed = (currentSum - target + p) % p;

            // If we have seen the needed remainder, we can consider this subarray
            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            // Store the current remainder and index
            modMap.put(currentSum, i);
        }

        // Step 4: Return result
        return minLen == n ? -1 : minLen;
    }
}