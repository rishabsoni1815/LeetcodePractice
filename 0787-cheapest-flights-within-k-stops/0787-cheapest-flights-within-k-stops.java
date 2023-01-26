class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) 
    {// 0->parent , 1-> cost, 2-> child
        int steps[]=new int[n+1];// to overcome diff. of duplicates in heap
       for(int i=0;i<=n;i++){
           steps[i]=Integer.MAX_VALUE;
       }
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] f:flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        q.offer(new int[]{src,0 ,0});
        while(!q.isEmpty())
        {
            int[] c=q.poll();
            int curr=c[0];
            int cost=c[1];
            int stop=c[2];
            if(curr==dst)
                return cost;
            if(steps[curr]<stop) continue;// to overcome diff. of duplicates in heap
            steps[curr]=stop;/*
            the no of steps required to reach node u is being captured (in steps array). If there exists another path to reach the node u (thats why it is in q as it might be someones neighbour) and if that path takes more number of steps than what was previously captured in the steps array for node u, then there is no point in processing the node further (as we already have a better way)
            */
            if(stop<=K)
            {   
                if(!map.containsKey(curr))
                    continue;//nodes with outdegree 0 as map so it will thorow null exception if not handled
                for(int[] next:map.get(curr))
                {
                    q.add(new int[]{next[0], cost+next[1], stop+1});
                }
            }
        }
        return -1;
    }
}