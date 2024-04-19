class Solution {
    public boolean isBipartite(int[][] g) {
        Queue<Integer>q=new LinkedList<>();
        HashMap<Integer,Integer>v=new HashMap<>();
        for(int j=0;j<g.length;j++){
            if(!v.containsKey(j)){
                v.put(j,0);
                q.add(j);
                while(q.size()>0){
                    int s=q.size();
                    for(int i=0;i<s;i++){
                        int c=q.poll();
                        for(int nei:g[c]){
                            if(v.containsKey(nei)==false){
                                v.put(nei,1-v.get(c));
                                q.add(nei);
                            }else{
                                if(v.get(c)==v.get(nei)) return false;
                            }
                        }
                    }
                }  
            } 
        }
        return true;
    }
}