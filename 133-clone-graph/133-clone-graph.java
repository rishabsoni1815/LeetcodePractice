/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        // HashSet<Node>v=new HashSet<>();
        // no need of visited array can check from hashmap only
        HashMap<Node,Node>h=new HashMap<>();
            dfs(node,h);
           for(Node j:h.keySet()){
               for(Node k:j.neighbors){
                   h.get(j).neighbors.add(h.get(k));//add j's neighbour to j's copy's (h.get(j)) neighbour arraylist  
               }
           }
          return h.get(node);
    }
    void dfs(Node node,HashMap<Node,Node>h){
         Node copy=new Node(node.val);
                h.put(node,copy);//adding to map like we add in visited array in first step in dfs
        for(Node i:node.neighbors){
            if(!h.containsKey(i)){//checking from map
               dfs(i,h);
            }
        }
    }
}