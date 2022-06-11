class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // we set a pq to store the minimum sum
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((i1, i2) -> ((i1.get(0) + i1.get(1)) - (i2.get(0) + i2.get(1))));
        
        // sum all elements in nums1 with nums2[0]
        
        // Why only nums2[0]? 
        // If we do O(k*k) match here, will trigger TLE.
        // So we only try first k elements in nums1 here
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            // What does last element mean?
            // it means the index we searched so far in nums2
            pq.add(new ArrayList<Integer>(Arrays.asList(nums1[i], nums2[0], 0)));
        }
        
        List<List<Integer>> ret = new ArrayList<>();

        while(!pq.isEmpty() && k > 0){
            List<Integer> cur = pq.poll();
            ret.add(new ArrayList<>(Arrays.asList(cur.get(0), cur.get(1))));
            k--;
            
            // bc we only do the traverse in nums1
            // so we sum the current smallest element in nums1
            // with the current searched smallest element in nums2
            if(cur.get(2) + 1 < nums2.length){
                pq.offer(new ArrayList<Integer>(Arrays.asList(cur.get(0), nums2[cur.get(2) + 1], cur.get(2) + 1)));
            }
        }
        
        return ret;
    }
}