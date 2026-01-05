class Solution {
    public long countBalanced(long low, long high) {
        return countSpecialNumbers(high)-countSpecialNumbers(low-1);
    }
    long countSpecialNumbers(long n) {
        char[] a = String.valueOf(n).toCharArray();
        Long dp[][][][]=new Long[a.length+1][2][201][2];//maintaining diff and pos not odd,even
        return help(0, a,true,dp,0,0) - 1 ;//to remove 000 case
    }
    long help(int i, char a[], boolean tight,Long dp[][][][],int diff,int pos) {
        if (i == a.length) {
            return diff==0?1:0;
        }
        long ans = 0;
        int cap=9;
        if(tight){
            cap=a[i]-'0';
        }
        if(dp[i][tight?0:1][diff+100][pos]!=null) return dp[i][tight?0:1][diff+100][pos];//adding 20 offset to avoid negative values while storing in dp array
        for (int x = 0; x <= cap; x++) {
            int ndiff=(pos==1)?diff+x:diff-x;
            ans+=help(i+1,a,tight && (x==cap),dp,ndiff,1-pos);
        }
        return dp[i][tight?0:1][diff+100][pos] = ans;
    }
}