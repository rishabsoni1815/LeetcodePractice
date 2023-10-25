class Solution {
    public int kthGrammar(int n, int k) {
       // 1 0
       // 2 01
       // 3 0110
       // 4 01101001
       // 5 0110100110010110
        if(n==1) return 0;
        int x=(int)Math.pow(2,n-1)/2;
        if(k<=x){
            return kthGrammar(n-1,k);
        }else{
            return 1-kthGrammar(n-1,k-x);
        }
    }
}