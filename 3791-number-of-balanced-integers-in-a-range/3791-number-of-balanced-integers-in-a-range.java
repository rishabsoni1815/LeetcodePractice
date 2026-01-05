class Solution {
    public long countBalanced(long low, long high) {
        return countSpecialNumbers(high)-countSpecialNumbers(low-1);
    }
    long countSpecialNumbers(long n) {
        char[] a = String.valueOf(n).toCharArray();
        Long dp[][][][][]=new Long[a.length+1][2][2][150][150];
        return help(0, a, true,true,dp,0,0) - 1 ;//to remove 000 case
    }
    long help(int i, char a[], boolean tight,boolean leadingZero,Long dp[][][][][],int odd,int even) {
        if (i == a.length) {
            return (odd==even)?1:0;
        }
        long ans = 0;
        int cap=9;
        if(tight){
            cap=a[i]-'0';
        }
        if(dp[i][tight?0:1][leadingZero?0:1][odd][even]!=null) return dp[i][tight?0:1][leadingZero?0:1][odd][even];
        for (int x = 0; x <= cap; x++) {
            if(leadingZero && x==0){
                // no need to remove as we didn't counted this since it is leading 0
                ans+=help(i+1,a,false,true,dp,odd,even);
            }else{
                ans+=help(i+1,a,tight && (x==cap),false,dp,(i%2!=0)?odd+x:odd,(i%2==0)?even+x:even);
            }
        }
        return dp[i][tight?0:1][leadingZero?0:1][odd][even] = ans;
    }
}