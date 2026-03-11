class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int x=(int)(Math.log(n)/Math.log(2)) + 1;
        int s=(int)Math.pow(2,x)-1;
        
        return n^s;
    }
}