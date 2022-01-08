class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1) return 0;
        if(k<=(int)(Math.pow(2,(n-2)))){
            return kthGrammar(n-1,k);
        }else{
            return kthGrammar(n-1,k-(int)(Math.pow(2,(n-2)))) ^ 1;// xor with 1 as 0^1 is 0 ns 1^1 is 0 (to inverse)
        }
        
        //                     1st half count    n
        // 0                   0                 1
        // 01                  1                 2
        // 0110                2                 3
        // 01101001            4                 4
        // 0110100110010110    8                 5
        //                     16                6
    }
}