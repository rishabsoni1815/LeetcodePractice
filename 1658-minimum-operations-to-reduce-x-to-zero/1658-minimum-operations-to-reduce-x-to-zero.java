class Solution {
    public int minOperations(int[] nums, int x) {
        // we can think of it as finding maximum length subarray which satisfies confition that sum of complete subarray - sum of this subarray is equal to x then only we will choose the element other than in subarry in array to subtract from x and make it 0, so problem now becomes to maximise this subarry length i.e longest subarry with sum = (total - x) 
        int sum=0;int n=nums.length;
        for(int t:nums){
            sum+=t;
        }
        int target=sum-x;
        if(target==0) return n;
        if(x>sum) return -1; // not possible
        int longest=subarraySum(nums,sum-x);
        return longest==0?-1:n-longest;
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);// use a test case
        int maxlen = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k)) {
                maxlen = Math.max(maxlen, i - map.get(sum-k));
            } 
            if (!map.containsKey(sum)) {
                map.put(sum, i);// to maximise length don't update index stored for sum if it is already present as i-map.get() will decrease with it or use some test cases to understand
            }
        }
        return maxlen;
    }
}



        /*
        
        //C++ DP-->TLE O(n^2) 
class Solution {
    unordered_map<string,int> mem;
    int solve(vector<int>& nums,int x,int left,int right,int count)
    {
        if(x==0)    //Sum found
            return count;
        if(x<0 or left>right)   //Out of bounds
            return 1e6;
        string key = to_string(left)+"*"+to_string(right)+"*"+to_string(x); //Form Key
        if(mem.count(key))  //Check if already calculated
            return mem[key];
        
        int l = solve(nums,x-nums[left],left+1,right,count+1);  //Include left element
        int r = solve(nums,x-nums[right],left,right-1,count+1); //Include right element
        return mem[key] = min(l,r);
    }
public:
    int minOperations(vector<int>& nums, int x) {
        int ans = solve(nums,x,0,nums.size()-1,0);
        return ans>=1e6?-1:ans;
    }
};

           
        */