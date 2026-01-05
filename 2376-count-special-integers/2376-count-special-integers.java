class Solution {
    public int countSpecialNumbers(int n) {
        char[] a = String.valueOf(n).toCharArray();
        int[] digits = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            digits[i] = a[i] - '0';
        }
        Integer dp[][][][]=new Integer[a.length+1][2][2][1<<10];//using visited hashet will not fir in dp state so using bitmast
        return help(0, digits, true,true,dp,0) - 1 ;//to remove 000 case
    }

    int help(int i, int a[], boolean tight,boolean leadingZero,Integer dp[][][][],int mask) {
        if (i == a.length) {
            return 1;
        }
        int ans = 0;
        int cap=9;
        if(tight){
            cap=a[i];
        }
        if(dp[i][tight?0:1][leadingZero?0:1][mask]!=null) return dp[i][tight?0:1][leadingZero?0:1][mask];
        for (int x = 0; x <= cap; x++) {
            if(leadingZero && x==0){
                // no need to remove as we didn't counted this since it is leading 0
                ans+=help(i+1,a,false,true,dp,mask);
            }else{
                if((mask & (1<<x)) == 0){//checkiing in mask if x bit is not set before
                // if(!v.contains(x)){
                    // v.add(x);
                    // Once we pick a non-zero, leading becomes false forever
                    ans+=help(i+1,a,tight && (x==cap),false,dp,(mask|(1<<x)));
                    // v.remove(x);
                }
            }
        }
        return dp[i][tight?0:1][leadingZero?0:1][mask] = ans;
    }
}