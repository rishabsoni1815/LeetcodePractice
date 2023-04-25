class SmallestInfiniteSet {
    TreeSet<Integer>h=new TreeSet<>();
    int cur=1;
    public SmallestInfiniteSet() {
        h=new TreeSet<>();
        cur=1;
    }
    
    public int popSmallest() {
        if(h.size()==0){
            return cur++;
        }else{
            return h.pollFirst();
        }
    }
    
    public void addBack(int num) {
        if(num<cur){
            h.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */