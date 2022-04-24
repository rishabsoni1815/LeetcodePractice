class Pair{
    String s;
    int t;
    Pair(String s,int t){
        this.s=s;
        this.t=t;
    }
}
class UndergroundSystem {
    HashMap<String,ArrayList<Integer>>sum=new HashMap<>();
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
            sum.get(cur).add(t-h.get(id).t);
        }else{
            ArrayList<Integer>v=new ArrayList<>();
            v.add(t-h.get(id).t);
            sum.put(cur,v);
        }
    }
    
    public double getAverageTime(String a, String b) {
        ArrayList<Integer>t=sum.get(a+'#'+b);
        double ans=0;
        for(int u:t){
            ans+=u;
        }
        return ans/(double)(t.size());
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */