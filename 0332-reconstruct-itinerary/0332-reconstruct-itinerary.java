class Solution {
    public List<String> findItinerary(List<List<String>> a) {
        int n=a.size();
        HashMap<String,PriorityQueue<String>>g=new HashMap<>();
        for(int i=0;i<n;i++){
            g.putIfAbsent(a.get(i).get(0),new PriorityQueue<String>());
            g.get(a.get(i).get(0)).add(a.get(i).get(1));//directed as You must use all the tickets once and only once
        }
        ArrayList<String>ans=new ArrayList<>();
        dfs("JFK",ans,g);
        return ans;
    }
    void dfs(String s, ArrayList<String>ans, HashMap<String,PriorityQueue<String>>g){
        PriorityQueue<String> nei =g.get(s);
        while (nei!=null && nei.isEmpty()==false){
            dfs(nei.poll(),ans,g);//poll() as removing edges which are visited
        }
        ans.add(0,s);// not adding normal as there can be test case where the lexicographically first neighbour doen't have a path to visit all stations so adding from the stations whose neighbour pri. queu becomes empty but that way the asn have to reverse so already did ans.add(0,s)
        
        /*
           as we do in toposrt wo add in stack
        
        */
    }
}