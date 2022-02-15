class Solution {
    public int[] singleNumber(int[] a) {
        int xor=0,n=a.length;
        for(int i=0;i<n;i++){
            xor^=a[i];
        }
        /*
         
         now xor is x^y => x and y are required answer and if a bit is set at position in xor it means that at that position x and y have diffrent bits , so we will make our array separate into 2 groups on basis of this difference so now the each of the 2 groups has only 1 of x or y in them as we haven't made grps on basis of bit position which is 0 ( that is both x and y have both bit as same) so now if we take xor of all numbers in both groups then we will find x in 1 grp and other in 2nd grp ( make diagram and see) 
        
        */
        
        int g1=0,g2=0;
        for(int i=0;i<32;i++){
            if(g1!=0) break;
            if((1<<i & xor) != 0){ // if both x and y have different bit(set bit) at this position then continue
            // now have to check
                for(int j=0;j<n;j++){
                   if((1<<i & a[j]) != 0){
                       g1^=a[j];
                   }else{
                       g2^=a[j];
                   }   
                }
            }
        }
        return new int []{g1,g2};
    }
}