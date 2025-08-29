class Solution {
    public long flowerGame(int n, int m) {
        int e=n/2;
        int o=(n+1)/2;
        int ee=m/2;
        int oo=(m+1)/2;
        return (long)e*oo + (long)o*ee;
    }
}