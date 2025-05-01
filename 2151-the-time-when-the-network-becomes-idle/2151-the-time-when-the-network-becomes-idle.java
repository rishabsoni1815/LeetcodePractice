class Solution {
    public int networkBecomesIdle(int[][] e, int[] p) {
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        int n=p.length;
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(e[i][1]);
            g.get(e[i][1]).add(e[i][0]);
        }
        int dis[]=new int[n];
        HashSet<Integer>v=new HashSet<>();
        v.add(0);
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        int cur=0;
        while(q.size()>0){
            int cs=q.size();
            while(cs-->0){
                int c=q.poll();
                for(int nei:g.get(c)){
                    if(v.contains(nei)==false && cur+1<dis[nei]){
                        v.add(nei);
                        q.add(nei);
                        dis[nei]=cur+1;
                    }
                }
            }
            cur++;
        }
        int ans=0;
        for(int i=1;i<n;i++){
            int c=dis[i]*2;
            int y=((c-1)/p[i])*p[i];
            int cmax=c+y;
            ans=Math.max(ans,cmax);
        }
        return ans+1;
    }
}