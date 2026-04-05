class Solution {
    public int findCheapestPrice(int n, int[][] f, int s, int d, int k) {
        ArrayList<ArrayList<int []>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<f.length;i++){
            g.get(f[i][0]).add(new int[]{f[i][1],f[i][2]});
        }
        Queue<int[]>q=new LinkedList<>();//node,stop
        q.add(new int[]{s,0});
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0;
        while(q.size()>0){
            int ss=q.size();
            int temp[]=dis.clone();
            while(ss-->0){
                int c[]=q.poll();
                for(int nei[]:g.get(c[0])){
                    if(temp[nei[0]]>(dis[c[0]]+nei[1]) && (c[1]+1<=(k+1))){
                        temp[nei[0]]=dis[c[0]]+nei[1];
                        q.add(new int[]{nei[0],c[1]+1});
                    }
                }
            }
            dis=temp;
        }
        return dis[d]!=Integer.MAX_VALUE? dis[d]:-1;
    }
}