class KthLargest {
    
    PriorityQueue<Integer>q;
    int size=0;
    public KthLargest(int k, int[] nums) {
        q=new PriorityQueue<>();
        for(int y:nums) q.add(y);
        size=k;
    }
    
    public int add(int val) {
        q.add(val);
        while(q.size()>size) q.poll();
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */