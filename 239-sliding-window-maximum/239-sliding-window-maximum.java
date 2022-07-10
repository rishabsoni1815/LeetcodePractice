class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n=a.length,yy=0;
        int ans[]=new int[n-k+1];
         Deque<Integer>q=new LinkedList<>();//as require max of current window in front and add next from last so want structure which so actions at both last and front
        int i=0,j=0;
        while(j<n){
            while(q.size()>0&&a[q.getLast()]<a[j]){
                q.removeLast();
            }//want to have only those numbers which can be maximum on removal of ith element from window on sliding it so maintaing decreasing order of elements in the dequeue and also before entering a new element in the list we want to have only the maximum candidates of future whrn first elemnt is removed so removing elements which are smaller then this new added alelemnt as they are no longwr the candidates of max. after removing cur max.
            q.addLast(j);//adding index so to compare max with first element in list before sliding window
            if(j-i+1 < k){//inc size of window
                j++;
            }else if(j-i+1 == k){//when window is of k size
                ans[yy]=a[q.getFirst()];//max is front of list
                yy++;
                if(q.size()>0&&q.getFirst()==i) q.removeFirst();//if cur max in window is first element of list so on inc. i this element should be removed as no longer it is the max as it is not in k size list now
                i++;
                j++;
            }
        }
         return ans;
    }
    
    /*
    
    // Brute-Force
// Check every sliding window and compute the maximum value.

public int[] maxSlidingWindow(int[] nums, int k) {
  // assume nums is not null
  int n = nums.length;
  if (n == 0 || k == 0) {
    return new int[0];
  }
  
  int numOfWindow = n - k + 1;
  int[] result = new int[numOfWindow]; // number of windows
  
  for (int start = 0; start < numOfWindow; ++start) {
    int end = start + k - 1;
    int maxVal = nums[start];
    for (int i = start + 1; i <= end; ++i) {
      if (nums[i] > maxVal) { // update
        maxVal = nums[i];
      }
    }
    result[start] = maxVal;
  }
  
  return result;
}
    
    
    */
}