class Solution {
    public int[] singleNumber(int[] nums) {
      //we can get xor of array and get x^y now we have to get x and y so as diff bits xor is 1 (1^0) ans same bits xor is 0(1^1 or 0^0 is 0) so if both numbers are diff one of the bit is diff so we can use every bit and separate the array in two grp one have that set will have the element btw x or y having that bit set and in the end from grp we can get x (by xorring the grp with )   
        //https://leetcode.com/problems/single-number-iii/discuss/1561785/Java-Simple-Bit-Manipulation-using-XOR-or-Two-Pass-or-Beats-100-0ms-or-TC%3AO(N)-SC%3AO(1)
        if (nums == null || nums.length < 2 || nums.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int aXORb = 0;
        for (int n : nums) {
            aXORb ^= n;
        }

        int rightSetBit = aXORb & -aXORb;
        int a = 0;
        for (int n : nums) {
            if ((n & rightSetBit) != 0) {
                a ^= n;
            }
        }

        return new int[] {a, aXORb ^ a};
    }
}