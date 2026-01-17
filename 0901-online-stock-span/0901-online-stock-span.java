class StockSpanner {
    Stack<Integer> s;
    HashMap<Integer,Integer>h;
    public StockSpanner() {
        s=new Stack<>();
        h=new HashMap<>();
    }

    public int next(int x) {
        int cnt=1;
        while (s.size() > 0 && s.peek() <= x) {
            cnt+=h.get(s.pop());
        }
        h.put(x,cnt);
        s.add(x);
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */