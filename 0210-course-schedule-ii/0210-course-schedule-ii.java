class Solution {
    public int[] findOrder(int n, int[][] a) {
        int m=a.length;
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        
        int in[]=new int[n];
        for(int i=0;i<m;i++){
            in[a[i][0]]++;
            g.get(a[i][1]).add(a[i][0]);
        }
        
        // HashSet<Integer>v=new HashSet<>();//can do without this also as we are checking in[nei]==0 which will be only once for every node
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0) {
                // v.add(i);
                q.add(i);
            }
        }
        int ans[]=new int[n];
        int ci=0;
        while(q.size()>0){
            int s=q.size();
            for(int i=0;i<s;i++){
                int c=q.poll();
                ans[ci++]=c;
                for(int nei:g.get(c)){
                    in[nei]--;
                    // if(!v.contains(nei) && in[nei]==0){
                    if(in[nei]==0){
                        q.add(nei);
                    }
                }
            }
        }
        if(ci==n) return ans;
        return new int[0];
    }
}