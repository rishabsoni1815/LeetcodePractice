class SnapshotArray {
    int x;
    TreeMap<Integer,Integer>h[];//as we can find the last snapId which was stored dont need to store all just store updated ones and when query comes search for that or greatest snapid less than that (Floor in map)
    public SnapshotArray(int n) {
        x=0;
        h=new TreeMap[n];
        for(int i=0;i<n;i++) {
            h[i]=new TreeMap<Integer,Integer>();
            h[i].put(0,0);//in question it is stated that Initially, each element equals 0.
        }
    }
    
    public void set(int i, int v) {
        h[i].put(x,v);
    }
    
    public int snap() {
        return x++;
    }
    
    public int get(int i, int id) {
        return h[i].floorEntry(id).getValue();//floorEntry gives key value pair
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */