class Solution {
    //  Let's think about the simplest case: how to remove 1 digit from the number so that the new number is the smallest possible？ Well, one can simply scan from left to right, and remove the first "peak" digit; the peak digit is larger than its right neighbor. One can repeat this procedure k times, and obtain the first algorithm:
    
   // public String removeKdigits(String num, int k) {
   //      StringBuilder sb = new StringBuilder(num);
   //      while (k > 0) {
   //          int i = 0;
   //          //find the peak
   //          while (i < sb.length() - 1
   //                  && sb.charAt(i) <= sb.charAt(i + 1)) {
   //              i++;
   //          }
   //          //delete the peak
   //          sb.deleteCharAt(i);
   //          k--;
   //      }
   //      //remove the leading 0s
   //      while (sb.toString().startsWith("0")) {
   //       sb.deleteCharAt(0);
   //      }
   //      return sb.length() == 0 ? "0" : sb.toString();
   //  }
    
    
    //To eliminate the peak, we can use a stack.

// With the help of a stack, we can track the peak elements and easily pop them out.
    
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            //check whether the current num is smaller than the top of the stack (means we have the peak)
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                //eliminate the peak
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        // handles the scenario where digits are equal, (1111, k=3)
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        //as stack follows LIFO
        sb.reverse();
        
        //remove leading zeros
        while (sb.toString().startsWith("0")) {
            sb.deleteCharAt(0);

        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}