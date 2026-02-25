class Solution {
    /*
    Claim 1: It is optimal that we make use of all rocks: There is never a benefit of not including a rock in Path 1 or Path 2, it is always positive or neutral.
Claim 2: It is never optimal to choose two consecutive rocks: If we choose rock_i, and rock_i+1, then rock_i+2 will have to do (rock_i+2)-(rock_i) work to return. Because the array is strictly increasing, it holds that (rock_i+2)-(rock_i) > (rock_i+1-rock_i)
Therefore one path must lie on each even index and the other path must lie on each odd index. We iterate through them and find the maximum distance.
    */ 
    public int maxJump(int[] stones) {
        int res = stones[1]-stones[0]; // store max difference
        for(int i = 3; i < stones.length; i+=2) res = Math.max(res, stones[i]-stones[i-2]); // odd path
        for(int i = 2; i < stones.length; i+=2) res = Math.max(res, stones[i]-stones[i-2]); // even path
        return res;
    }
}