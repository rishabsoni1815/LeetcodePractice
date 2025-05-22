class Solution {
    public int maxRemoval(int[] a, int[][] q) {
        PriorityQueue<int[]>canTake=new PriorityQueue<>((x,y)-> y[1]-x[1]);//desc order of queries by r
        PriorityQueue<Integer>current=new PriorityQueue<>();//asc of r of queries
        Arrays.sort(q,(x,y) -> x[0]-y[0]);//asc by l of queries
        int j=0;
        int ans=0;
        for(int i=0;i<a.length;i++){
            while(j<q.length && i>=q[j][0]){
                canTake.add(new int[]{q[j][0],q[j][1]});
                j++;
            }
            while(current.size()>0 && current.peek()<i){
                current.poll();
            }
            if(current.size()>=a[i]) continue;
            a[i]-=current.size();
            while(a[i]>0 && canTake.size()>0 && canTake.peek()[1]>=i){
                a[i]--;
                ans++;
                current.add(canTake.poll()[1]);
            }
            if(a[i]>0) return -1;
        }
        return q.length-ans;
    }
}