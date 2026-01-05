class Solution {
    public long countBalanced(long low, long high) {
        return countSpecialNumbers(high)-countSpecialNumbers(low-1);
    }
    long countSpecialNumbers(long n) {
        char[] a = String.valueOf(n).toCharArray();
        Long dp[][][][]=new Long[a.length+1][2][150][150];
        return help(0, a,true,dp,0,0) - 1 ;//to remove 000 case and no need of leadingzero here ans event if we append leading zero odd places and even places sum is same so no need to handle leading zero seperately
    }
    long help(int i, char a[], boolean tight,Long dp[][][][],int odd,int even) {
        if (i == a.length) {
            return (odd==even)?1:0;
        }
        long ans = 0;
        int cap=9;
        if(tight){
            cap=a[i]-'0';
        }
        if(dp[i][tight?0:1][odd][even]!=null) return dp[i][tight?0:1][odd][even];
        for (int x = 0; x <= cap; x++) {
                ans+=help(i+1,a,tight && (x==cap),dp,(i%2!=0)?odd+x:odd,(i%2==0)?even+x:even);
        }
        return dp[i][tight?0:1][odd][even] = ans;
    }
}