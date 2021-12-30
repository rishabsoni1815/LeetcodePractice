class Solution {
    public int smallestRepunitDivByK(int k) {
        int n=0;int ans=1;
        for(int i=1;i<=k;i++){
            n=(n*10 + 1)%k;
            if(n%k==0) return i;
        }
        return -1;
    }
}