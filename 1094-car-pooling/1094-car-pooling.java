class Solution {
    public boolean carPooling(int[][] t, int c) {
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(x[0]-y[0]));//0->end, 1->cap
        Arrays.sort(t,(x,y)->(x[1]-y[1]));
        int dis=0,cap=0;
        for(int i=0;i<t.length;i++){
            dis=Math.max(dis,t[i][1]);
            System.out.println(dis);
            while(q.size()>0 && q.peek()[0]<=dis){
                cap-=q.poll()[1];
            }
            cap+=t[i][0];
            if(cap>c) return false;
            q.add(new int[]{t[i][2],t[i][0]});
        }
        return true;
    }
}