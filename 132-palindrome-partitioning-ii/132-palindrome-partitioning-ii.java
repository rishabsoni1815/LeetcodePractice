class Solution {
    public int minCut(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
       return help(s,s.length(),0,dp)-1;//subtracting partition at end
    }
   int help(String s,int n,int i,int dp[]){
       if(i==n) return 0;
       if(dp[i]!=-1) return dp[i];
       int min=Integer.MAX_VALUE;
       for(int j=i;j<n;j++){
           if(is(s,i,j)){
               min=Math.min(min,1+help(s,n,j+1,dp));
           }
       }
       return dp[i]=min;
    }
     boolean is(String str, int start, int end){
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