class DataStream {
    private int value = 0, k = 0, cnt = 0; 

    public DataStream(int value, int k) {
        this.value = value; 
        this.k = k; 
    }
    
    public boolean consec(int num) {
        if (value == num) ++cnt; 
        else cnt = 0; 
        return cnt >= k; 
    }
}