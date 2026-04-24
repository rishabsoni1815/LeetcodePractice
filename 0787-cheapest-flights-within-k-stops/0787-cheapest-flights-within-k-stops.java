class Solution {
    public int findCheapestPrice(int n, int[][] e, int s, int d, int k) {
        ArrayList<ArrayList<int []>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(new int[]{e[i][1],e[i][2]});
        }
        PriorityQueue<int[]>q=new PriorityQueue<>((x,y)->(x[2]-y[2]));
        q.add(new int[]{s,0,0});//node,price,stop
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0;
        while(q.size()>0){
            int c[]=q.poll();
            if(c[2]>k) continue;
            for(int nei[]:g.get(c[0])){
                if(dis[nei[0]]>c[1]+nei[1]){
                    dis[nei[0]]=c[1]+nei[1];
                    q.add(new int[]{nei[0],dis[nei[0]],c[2]+1});
                }
            }
        }
        return dis[d]!=Integer.MAX_VALUE ? dis[d]:-1;
    }
}