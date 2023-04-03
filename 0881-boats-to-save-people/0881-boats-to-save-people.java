/*

Let's talk about what we'll do when we face possibility no. 1.0 (people[left] + people[right]<=limit)
If that's the case then we only require single boat & increment the boatCount, left pointer & decrement the right pointer

Let's talk about what we'll do when we face possibility no. 2.0
If that's the case then we only one person will go in boat & increment the boatCount & decrement the right pointer

*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                boatCount++;
                left++;
                right--;
            }
            else{
                boatCount++;
                right--;
            }
        }
        return boatCount;
    }
}