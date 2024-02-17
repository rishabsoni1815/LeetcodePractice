class Solution {
    public int furthestBuilding(int[] h, int b, int l) {
        int n=h.length;
        int csum=0;
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            if(i+1<n && h[i]<h[i+1]){
                q.add((h[i+1]-h[i]));
                csum+=(h[i+1]-h[i]);
            }
            if(csum>b){
                if(l==0) return i;
                l--;
                if(q.size()>0) csum-=q.poll();
            }
        }
        return n-1;
    }
}