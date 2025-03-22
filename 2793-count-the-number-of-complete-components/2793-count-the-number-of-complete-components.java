class Solution {
    public int countCompleteComponents(int n, int[][] e) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<Integer>());
        }
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(e[i][1]);
            g.get(e[i][1]).add(e[i][0]);
        }
        HashSet<Integer>v=new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(!v.contains(i)){
                int c[]=new int[2];//0->vertices,1->edges
                dfs(i,v,g,c);
                int cnt=(c[0]*(c[0]-1))/2;
                System.out.println(i+" "+c[0]+" "+c[1]);
                if(2*cnt==c[1]) ans++;//since undirected so counted edges twice
            }
        }
        return ans;
    }
    void dfs(int i,HashSet<Integer>v,ArrayList<ArrayList<Integer>>g,int c[]){
        v.add(i);
        c[0]++;
        c[1]+=g.get(i).size();
        for(int nei:g.get(i)){
            if(!v.contains(nei)){
                dfs(nei,v,g,c);
            }
        }
    }
}