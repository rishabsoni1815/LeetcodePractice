class Solution {
    public boolean canCross(int[] a) {
        int n=a.length;
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<n;i++) h.put(a[i],i);
        Boolean dp[][]=new Boolean[n][2002];
        return help(0,n,a,0,h,dp);
    }
    boolean help(int i,int n,int a[],int k,HashMap<Integer,Integer>h,Boolean dp[][]){
        if(i==n-1) return true;
        if(i>=n||k<0) return false;
        if(dp[i][k]!=null) return dp[i][k];
        boolean ans=false;
        if(k-1>0 && h.containsKey(a[i]+k-1)) {
            ans|=help(h.get(a[i]+k-1),n,a,k-1,h,dp);
        }
        if(k>0 && h.containsKey(a[i]+k)) {
            ans|=help(h.get(a[i]+k),n,a,k,h,dp);
        }
        if(k+1>0 && h.containsKey(a[i]+k+1)) {
            ans|=help(h.get(a[i]+k+1),n,a,k+1,h,dp);
        }
        return dp[i][k]=ans;
    }
}