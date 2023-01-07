class Solution {
     public int canCompleteCircuit(int[] gas, int[] cost) {
         int gassum=0,costsum=0;
         for(int i:gas) gassum+=i;
         for(int i:cost) costsum+=i;
         if(gassum<costsum) return -1;
         //so now sol. is always possible
            int total = 0, tank = 0, index = 0;
            for (int i = 0; i < cost.length; i++) {
                int consume = gas[i] - cost[i];
                tank += consume;//if tank val. is -ve at any point that means we have to start from next (index=i+1) and if after completeing if total is +ve that means from where we started after tans<0 the sum after that was greater than before (that is why total was >0) so it is possible to complete from i+1 so we will return index(i+1)
                if (tank < 0) {
                    index = i + 1;
                    tank = 0;
                }
                total += consume;
            }
            return total < 0 ? -1 : index;//as sol. always possible and start from index never gave -ve total so total-the indexes sum i.e. (0,index) will always be +ve as ans. is always possible  
        }
    
    /*
    
    brute->o(n^2) start from every index and check if can complete
       class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            for (int i = 0; i < n; i++) {
                int total = 0, stopCount = 0, j = i;
                while (stopCount < n) { // loop for n stops
                    total += gas[j % n] - cost[j % n];
                    if (total < 0) // starting from this stop we can't complete trip break
                        break;
                    stopCount++;
                    j++;
                }
                if (stopCount == n && total >= 0)  // if we are able to cover all the stop and fuel +ve return i'th stop
                    return i;
            }

            return -1;
        }
    
    */
}