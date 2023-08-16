class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n=a.length;
        int ans[]=new int[n-k+1];
        int j=0;
        Deque<Integer>q=new LinkedList<>();//as require max of current window in front and add next from last so want structure which so actions at both last and front
        while(j<n){
            while(q.size()>0 && a[j]>q.peekLast()){
                q.pollLast();
            }//want to have only those numbers which can be maximum on removal of 1st element from window on sliding it so maintaing decreasing order of elements in the dequeue and also before entering a new element in the list we want to have only the elemts greater than this as if this is in window they are of no use as this will be our max
            q.add(a[j]);//adding our element
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