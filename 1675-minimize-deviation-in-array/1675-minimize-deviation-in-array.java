class Solution {
    public int minimumDeviation(int[] nums) {
        // make all odds as even by 1 operation
        // even can't increase further(even can only dec  as only /2 available)
        // max diff=> max-min but now as all are even so min can't increase(even can't) so we have to decreae maximum ( by dividing by 2 until it's odd as if we again change it to even  (by *2) then again will/2 and this cycle will go on so /2 till its even) and keep track of max diff b/w curr max and minimum in all array can do by max heap
        
        int n=nums.length;int min=Integer.MAX_VALUE;
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0) nums[i]*=2;
            q.add(nums[i]);
            min=Math.min(min,nums[i]);
        }
        int diff=q.peek()-min;
        while(q.peek()%2==0){
            diff=Math.min(diff,q.peek()-min);
            min=Math.min(min,q.peek()/2);// updating min as updating q with adding q.poll()/2 and removing q.poll()
            if(q.peek()%2==0){// if even then /2 i.e. decrease(dec max. as can't inc min as all are even)
                q.add(q.poll()/2);
            }
        }
        return Math.min(diff,q.peek()-min);// as at last if a odd is added the while loops don't run so have to update diff one last time
    }
}