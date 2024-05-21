class Solution {
    public long maximumScoreAfterOperations(int[][] e, int[] k) {
        int n=e.length+1;
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<Integer>());
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(e[i][1]);
            g.get(e[i][1]).add(e[i][0]);//undirected
        }
        HashSet<Integer>v=new HashSet<>();
        long sum=0L;
        for(int u:k) sum+=(long)u;
        return sum-dfs(0,v,g,k);
    }
    long dfs(int i,HashSet<Integer>v,ArrayList<ArrayList<Integer>>g,int k[]){//gives the sum that will be deleted from total
        v.add(i);
        long sum=0L;//sum of all the individual child's sum to be deleted
        int x=0;
        if(g.get(i).size()==1 && i!=0) return k[i];//leaf as undirected so cant just check g.get(i).size()==0 as lets say 2 node anre there only 1 is leaf but both have edge to each other (undirected) and 0 is root so csant be leaf (as n>2 always as given )
        //can also understand as leaf-> outdegre=0 and it is tree so indegree is always 1 so total degree = in+out=1+0=1 
        for(int nei:g.get(i)){
            if(!v.contains(nei)){
                x++;
                long c=dfs(nei,v,g,k);
                sum+=c;
            }
        }        
        if(sum<k[i]){//keep this i and continue deleteing sum's node
            return sum;
        }else{
            return k[i];
        }
    }
}