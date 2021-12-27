class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
         int x=1;
        for(int i=0;i<=(int)(Math.log(n)/Math.log(2));i++){
            n^=x;
            x=x<<1;
        }
        return n;
    }
}