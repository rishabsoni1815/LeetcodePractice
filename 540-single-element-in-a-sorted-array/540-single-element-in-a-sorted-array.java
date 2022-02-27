class Solution {
   public int singleNonDuplicate(int[] nums) {
        // Let the search range be [L, R]. Now, when we consider the mid element, the array is split into two equal halves on the left and right sides. Then we have following cases -

// 1)nums[mid] == nums[mid+1]:

// Left Half Length = Right Half Length = Even : In this case, we can be sure that our answer lies in the right half. How? One element of right half: nums[mid+1] matches with nums[mid]. So, leaving nums[mid+1] aside, we only have odd number of elements to pair up with each other in the right half. This means one element must be such that it cannot be paired with anyone and this is our required answer that occurs only once. So do L = mid+2 (+2 to skip nums[mid] and nums[mid+1] & keep search space odd for next iteration)
// Left Half Length = Right Half Length = Odd : In this case, we can be sure that our answer lies in the left half. Again, how? Following same reasoning, one element of left half: nums[mid+1] matches with nums[mid]. So, leaving nums[mid+1] aside, the right half consists of even number of elements which can pair up with each other completely. However, left half only consists odd elements and thus one element which cannot be paired with anyone is our required answer. So do R = mid-1 (-1 to skip nums[mid] & keep search space odd for next iteration)

    // 2)nums[mid] == nums[mid-1]: We can follow similar reasoning based on array lengths as above -
// Left Half Length = Right Half Length = Even : The answer lies in the left half. How? One element of left half: nums[mid-1] matches with nums[mid]. This leaves left half with odd number of elements to pair up with each other and one element that cant be paired with anyone is the required answer. So do R = mid-2
// Left Half Length = Right Half Length = Odd : The answer lies in right half. How? One element of left half: nums[mid-1] matches with nums[mid]. This leaves left half with even number of elements which can pair up with each other completely. However, right half only consists odd elements and thus one element which cannot be paired with any other is the required answer. So do L = mid+1.

    // 3)If neither of above condition are satisfied, then we can be sure that nums[mid] itself is the required element occuring once (since it doesnt match with its neighbours). So we can just return it.
        int L = 0, R = nums.length - 1; 
        while(L <= R) {
           int mid = (L + R) >> 1;
            boolean isHalfEven = (mid-L) % 2 == 0;          // check length of each half is odd or even (mid-L) is length of left half but as n is always odd (observe by tc) so laft half length==right half length
			
            if(mid+1 < nums.length && nums[mid] == nums[mid+1])    // case: 1
                if(isHalfEven) L = mid+2;
                else R = mid-1;
				
            else if(mid>0 && nums[mid] == nums[mid-1])     // case: 2
                if(isHalfEven) R = mid-2;
                else L = mid+1;
				
            else return nums[mid];                       // case: 3
        }
        return -1; 
    }
}