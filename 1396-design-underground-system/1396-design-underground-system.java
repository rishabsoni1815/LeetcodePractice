class Pair{
    String s;
    int t;
    Pair(String s,int t){
        this.s=s;
        this.t=t;
    }
}
class Pair1{
    int c;
    long s;
    Pair1(int c,long s){
        this.s=s;
        this.c=c;
    }
}
class UndergroundSystem {
    HashMap<String,Pair1>sum=new HashMap<>();
    HashMap<Integer,Pair>h=new HashMap<>();
    public UndergroundSystem() {
        h=new HashMap<>();
        sum=new HashMap<>();
    }
    
    public void checkIn(int id, String s, int t) {
        h.put(id,new Pair(s,t));
    }
    
    public void checkOut(int id, String s, int t) {
        String cur=((h.get(id).s)+"#"+s);
        if(sum.containsKey(cur)){
            sum.get(cur).s+=(t-h.get(id).t);
            sum.get(cur).c++;
        }else{
            long y=t-h.get(id).t;
            sum.put(cur,new Pair1(1,y));
        }
    }
    
    public double getAverageTime(String a, String b) {
        long t=sum.get(a+'#'+b).s;
        return t/(double)(sum.get(a+'#'+b).c);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */