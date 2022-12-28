class Solution {
    public int minStoneSum(int[] a, int k) {
        int n=a.length;
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:a){
            q.add(x);
        }
        while(k>0 && q.size()>0){
            int x=q.poll();
            k--;
            q.add((int)Math.ceil(x/2.0));
        }
        int ans=0;
        while(q.size()>0){
            ans+=q.poll();
        }
        return ans;
    }
}