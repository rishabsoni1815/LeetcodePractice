class Solution {
//     public int findMaxK(int[] nums) {
//         int ans = -1; 

//         // A set to store seen numbers
//         Set<Integer> seen = new HashSet<>();

//         for (int num : nums) { 
//             int absNum = Math.abs(num);

//             // If the absolute value is greater than the current maximum and its negative counter part is seen
//             if (absNum > ans && seen.contains(-num))
//                 ans = absNum; 
//             seen.add(num); // Insert the current number into the set
//         }

//         return ans;
//     }
    
    //we can also use boolean array (size less as boolean is of 1 bit while int is of 4 bytes i.e 32 bits)
    public int findMaxK(int[] nums) {
        int ans=-1;
        boolean h[]=new boolean [2001];//as -1000 to 1000 so create for 0 to 2000
        for(int e:nums){
            if(h[-e+1000]==true) {//here also checking negation exists or not already for this element
                ans=Math.max(ans,Math.abs(e));
            }
            h[e+1000]=true;//add this element
        }
        return ans;
    }
}