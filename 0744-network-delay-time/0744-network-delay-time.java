class Solution {//array={node,weight}
   public int networkDelayTime(int[][] times, int n, int k) {
        //0-> u,1->v,2->weight  graph is directed 

        ArrayList<ArrayList<int []>>g=new ArrayList<>();//0-> vertex,1->edge
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            g.get(times[i][0]-1).add(new int[]{times[i][1]-1,times[i][2]});
        }
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(x[1]-y[1]));//descending
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        q.add(new int[]{k-1,0});
        dis[k-1]=0;
        while(q.size()>0){
            int c[]=q.poll();
            for(int nei[]:g.get(c[0])){
                if(dis[nei[0]]>c[1] +nei[1]){
                    dis[nei[0]]=c[1]+nei[1];
                    q.add(new int[]{nei[0],dis[nei[0]]});
                }   
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dis[i]==Integer.MAX_VALUE) return -1;
            else ans=Math.max(ans,dis[i]);
        }
        return ans;
    }
}