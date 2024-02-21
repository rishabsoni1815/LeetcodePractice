class Solution {
    public int rangeBitwiseAnd(int l, int r) {
        // as we see if we encount 0 in a bit once then all and will be 0 only so after observation we can see that just some prex wil be there that will be non 0 other will become 0 ( as rightmost is 0 to 1 in 1 step and goinf leftward diff increases (2->4->8) etc so once we encounter 0 all are zero so just check till waht we have 1 from left most)
        //to find longest common prefix just >> both until they arre smae (commoon prefix) https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56729/Bit-operation-solution(JAVA)/58131
        
        int zeroes=0;
        while(l!=r){
            l>>=1;
            r>>=1;
            zeroes++;
        }
        return l<<zeroes;//adding all zeroes at end
    }
}