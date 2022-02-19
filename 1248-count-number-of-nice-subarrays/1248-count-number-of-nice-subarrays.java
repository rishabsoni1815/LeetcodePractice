
/*
// o(n) time and o(n) space ->sliding window space-> o(1)
class Solution {
    public int numberOfSubarrays(int[] a, int k) {
        //like number of subarrays with sum k here sum is analoged as number of odd elements
        int n=a.length;
        HashMap<Integer,Integer>h=new HashMap<>();
        h.put(0,1);
        int c=0,ans=0;
        for(int i=0;i<n;i++){
            if(a[i]%2!=0) c++;
            if(h.containsKey(c-k)){
                ans+=h.get(c-k);
            }
            h.put(c,h.getOrDefault(c,0)+1);
        }
        return ans;
    }
}
*/

//sliding window O(n) time and O(1) space
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddcount=0;
        int res=0;
        int i=0;
        int count=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2==1){
                oddcount++;
                count=0;
            }
            while(oddcount==k){
                if(nums[i++]%2==1) oddcount--;
                count++;
            }
            res+=count;
        }
        return res;
    }
}