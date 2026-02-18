class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev=-1;
        while(n>0){
            int cur=0;
            if(n%2!=0){
                cur=1;
            }
            if(cur==prev) return false;
            prev=cur;
            n=n>>1;
        }
        return true;
    }
}