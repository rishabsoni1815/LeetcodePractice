class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n=a.length;
        int ans[]=new int[n-k+1];
        int j=0;
        Deque<Integer>q=new LinkedList<>();
        while(j<n){
            while(q.size()>0 && a[j]>q.peekLast()){
                q.pollLast();
            }
            q.add(a[j]);
            if(j>=k-1){
                ans[j-k+1]=q.peekFirst();
                if(a[j-k+1]==q.peekFirst()){
                    q.pollFirst();
                }
            }
            j++;
        }
        return ans;
    }
}