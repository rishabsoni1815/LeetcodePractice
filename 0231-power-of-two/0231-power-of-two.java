class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return ((n & (n-1))==0);
        
//          // using log and checking if its an integer by checking 
//         // decimal part is zero or not decimal part->n%1
//          return (Math.log10(n) / Math.log10(2)) % 1 == 0;
        
       
    }
}