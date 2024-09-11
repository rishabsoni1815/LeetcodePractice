class Solution {
    public int minBitFlips(int a, int b) {
        int x=a^b;
        int cnt=0;
        while(x>0){
            if(x%2!=0) cnt++;
            x=x>>1;
        }
        return cnt;
    }
}