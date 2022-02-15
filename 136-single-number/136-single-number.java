class Solution {
    public int singleNumber(int[] a) {
        int xor=0;
        for(int n:a){
            xor^=n;
        }
        return xor;
    }
}