class Solution {
    // public boolean containsNearbyDuplicate(int[] a, int k) {
    //     HashMap<Integer,Integer>h=new HashMap<>();
    //     for(int i=0;i<a.length;i++){
    //         if(h.containsKey(a[i])){
    //             if(Math.abs(i-h.get(a[i]))<=k) return true;
    //         }
    //         h.put(a[i],i);
    //     }
    //     return false;
    // }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
}