class Solution {
    int minAbsoluteDifference(List<Integer> nums, int x) {
    int ans = Integer.MAX_VALUE;
    TreeSet<Integer> s = new TreeSet<>();
    for(int i = x; i < nums.size(); ++i){
        s.add(nums.get(i-x));//just checking ele to left of a[i] as if check on both left n right then complex code and if checking only left then a[i+k]....a[n] when thre turn comes check for a[i] right so we wanr pair so a[i],a[j]  or a[j],a[i] doesn't matter
        Integer high = s.ceiling(nums.get(i)), low = s.floor(nums.get(i));
        if(high != null) ans = Math.min(ans, Math.abs(nums.get(i) - high));
        if(low != null) ans = Math.min(ans, Math.abs(nums.get(i) - low));
    }
    return ans;
}
}