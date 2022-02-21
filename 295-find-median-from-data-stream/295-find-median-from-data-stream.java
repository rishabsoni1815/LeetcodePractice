class MedianFinder {

    /** initialize your data structure here. */
    
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    //cant use sorting nlogn as they require complete data hhere can use insertion dort but it is o(n^2)
    
    public MedianFinder() {
         max = new PriorityQueue<>(Collections.reverseOrder());//max heap for first half of sorted array as we need max of first hasl
         min = new PriorityQueue<>();//min heap for 2nd healf as we need min of 2nd healf of sorted array
        //default min heap
    }
    
    public void addNum(int num) {
        if(max.isEmpty()||max.peek()>num){//means it belong to first half of sorted array so add to max heap as first element should go to first half so max.isEmpty() condition
            max.add(num);
        }else{
            min.add(num);
        }
        if(max.size()>min.size()+1){//if diff b/w size of both is >=2
            min.add(max.peek());
            max.poll();
        }
        else if(min.size()>max.size()+1){//if diff b/w size of both is >=2
            max.add(min.peek());
            min.poll();
        }
    }
    
    public double findMedian() {
          if ((max.size()+min.size())%2==0)
             return (max.peek() + min.peek()) / 2.0;
        //important not 2.0
          else
             return min.size() > max.size() ? min.peek() : max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */