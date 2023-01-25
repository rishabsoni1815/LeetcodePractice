class Solution {
    public int closestMeetingNode(int[] e, int a, int b) {
        int n=e.length;
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
           if(e[i]!=-1) g.get(i).add(e[i]);
        }
        int dis1[]=new int[n];
        int dis2[]=new int[n];
        bfs(dis1,a,g);
        bfs(dis2,b,g);
        // for(int i:dis1) System.out.print(i+" ");
        // System.out.println();
        // for(int i:dis2) System.out.print(i+" ");
        int min=Integer.MAX_VALUE-1,mini=-1;
        for(int i=0;i<n;i++){
            if(dis1[i]==(Integer.MAX_VALUE-1)) continue;
            if(dis2[i]==(Integer.MAX_VALUE-1)) continue;
            int max=Math.max(dis1[i],dis2[i]);
            if(max<min){
                min=max;
                mini=i;
            }
        }
        return mini;
    }
    void bfs(int d[],int a,ArrayList<ArrayList<Integer>>g){
        boolean v[]=new boolean[d.length];
        Queue<Integer>q=new LinkedList<>();
        q.add(a);
        Arrays.fill(d,Integer.MAX_VALUE-1);
        d[a]=0;
        v[a]=true;
        while(q.size()>0){
            int s=q.size();
            for(int i=0;i<s;i++){
                int t=q.poll();
                for(int nei:g.get(t)){
                    if(v[nei]==false && d[t]+1<d[nei]){
                        d[nei]=d[t]+1;
                        v[nei]=true;
                        q.add(nei);
                    }
                }
            }
        }
    }
}