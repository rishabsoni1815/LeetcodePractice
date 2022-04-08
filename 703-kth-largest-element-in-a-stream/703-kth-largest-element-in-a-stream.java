class KthLargest {
    int kk=0;
    PriorityQueue<Integer>q=new PriorityQueue<>();
    public KthLargest(int k, int[] a) {
        kk=k;
        for(int i:a){
            q.add(i);
        }
    }
    
    public int add(int val) {
        q.add(val);
        while(q.size()>kk){
            q.poll();
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */