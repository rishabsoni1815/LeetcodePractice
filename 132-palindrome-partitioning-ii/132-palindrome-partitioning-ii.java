class Solution {
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--){//require j+1 so from n to 0
            int min=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
                if(check(s,i,j)) {//don't pass substring as it takes n^2
                    min=Math.min(min,1+dp[j+1]);
                }
            }
            dp[i]=min;
        }
        return dp[0]-1;
        //memoisation
        // Integer dp[]=new Integer[s.length()];
        // return help(0,s,dp)-1;
    }
     int help(int i,String s,Integer dp[]){
		if(i==s.length()) {
			return 0;
		}
         if(dp[i]!=null) return dp[i];
         int min=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(check(s,i,j)) {//don't pass substring as it takes n^2
            	min=Math.min(min,1+help(j+1,s,dp));
            }
        }
         return dp[i]=min;
    }
	boolean check(String str,int start,int end) {
        while(start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
	}
}