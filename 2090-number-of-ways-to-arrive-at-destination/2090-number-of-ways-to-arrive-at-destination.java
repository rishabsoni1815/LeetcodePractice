class Solution {
    public int countPaths(int n, int[][] e) {
        //dijsktra but when cdis+ndis == dis[nnode] we can add this to the total ways as this has been visited again with minimum distance 
        
        int m=(int)(1e9 + 7);
        ArrayList<ArrayList<int []>>g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<int[]>());
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(new int[]{e[i][1],e[i][2]});
            g.get(e[i][1]).add(new int[]{e[i][0],e[i][2]});
        }
        PriorityQueue<long []>q=new PriorityQueue<long []>((x,y)->(Long.compare(x[0],y[0])));//0->wt,1->node
        q.add(new long[]{0,0});
        long dis[]=new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0]=0;
        long ways[]=new long[n];
        ways[0]=1;
        
        while(q.size()>0){
            long c[]=q.poll();
            long cdis=c[0];
            int cnode=(int)c[1];
            for(int nei[]:g.get(cnode)){
                int ndis=(int)nei[1];
                int nnode=(int)nei[0];
                if((long)cdis+ndis < dis[nnode]){
                    dis[nnode] = (long)cdis+ndis;
                    q.add(new long[]{dis[nnode],nnode});
                    ways[nnode]=ways[cnode];
                }else if(cdis+ndis == dis[nnode]){
                    ways[nnode]=(ways[nnode]%m+ways[cnode]%m)%m;
                }
            }
        }
        return (int)ways[n-1]%m;
    }
}