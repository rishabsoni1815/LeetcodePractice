class SmallestInfiniteSet {
    TreeSet<Integer>h=new TreeSet<>();
    public SmallestInfiniteSet() {
        h=new TreeSet<>();
        for(int i=1;i<=1000;i++) h.add(i);
    }
    
    public int popSmallest() {
        return h.pollFirst();
    }
    
    public void addBack(int num) {
        h.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */