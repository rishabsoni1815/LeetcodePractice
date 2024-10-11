class Solution {
    public int smallestChair(int[][] a, int t) {
        int s=a[t][0];
        
        Arrays.sort(a,(x,y)->(x[0]-y[0]));
        int n=a.length;
        
        
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(x[1]!=y[1])?(x[1]-y[1]):(x[0]-y[0]));//0->start,1->end,2-> chair number
        
        q.add(new int[]{a[0][0],a[0][1],0});//0 is assigned to first
        
        TreeSet<Integer>unUsed=new TreeSet<>();
        for(int i=1;i<n;i++) unUsed.add(i);
        
        for(int i=1;i<n;i++){
            while(q.size()>0 && a[i][0]>=q.peek()[1]){
                // System.out.println(a[i][0]+" "+q.peek()[1]+" "+q.peek()[2]);
                unUsed.add(q.poll()[2]);
            }
            // System.out.println(unUsed);
            if(a[i][0]==s) return unUsed.removeFirst();
            q.add(new int[]{a[i][0],a[i][1],unUsed.removeFirst()});
        }
        return 0;
    }
}