class MyCircularQueue {
    int a[];
    int s=0,e=0,cs=0,rs;
    public MyCircularQueue(int k) {
        a=new int [k];
        s=k-1;e=k-1;cs=0;rs=k;
    }
    
    public boolean enQueue(int v) {
        if(cs<rs){
            s=(s-1+rs)%rs;
            a[s%rs]=v;
            cs++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(cs>0){
            e=(e-1+rs)%rs;
            cs--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(cs>0) return a[(e-1+rs)%rs];
        return -1;
    }
    
    public int Rear() {
        if(cs>0) return a[s];
        return -1;
    }
    
    public boolean isEmpty() {
        return cs==0;
    }
    
    public boolean isFull() {
        return cs==rs;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */