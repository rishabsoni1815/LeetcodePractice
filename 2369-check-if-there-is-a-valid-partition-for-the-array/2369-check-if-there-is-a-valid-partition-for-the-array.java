class Solution {
    public boolean validPartition(int[] a) {
        int n=a.length;
        //2,3,5,7 length of consecutive is okay
        //3 length of consecutve is okay
        Boolean dp[]=new Boolean [n];
        return help(n-1,dp,a);
    }
    boolean help(int i,Boolean dp[],int a[]){
        if(i<0) return true;
        boolean ans=false;
        if(dp[i]!=null) return dp[i];
        if(i>=1){
            if(a[i]==a[i-1]){
                ans|=help(i-2,dp,a);
            }
            if(i>=2){
                if(a[i]==a[i-1] && a[i-1]==a[i-2]) ans|=help(i-3,dp,a);
            }
        }
        if(i>=2){
            if((a[i]==a[i-1]+1) && (a[i-1]==a[i-2]+1)) ans|=help(i-3,dp,a);
        }
        return dp[i]=ans;
    }
}