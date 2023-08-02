class Solution {
    static HashMap<Integer,Integer>h;
    public boolean canCross(int[] a) {
        h=new HashMap<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            h.put(a[i],i);
        }
        Boolean dp[][]=new Boolean[n][2002];//mak k can be 2001 so 2002 just for comfort
        return help(0,a,n,0,dp);//k here is 0 so that 1st jump becomes 1 when k+1 i done if k=1 then k+1=2 which make first jump as 2
    }
    boolean help(int i,int a[],int n,int k,Boolean dp[][]){
        if(i==n-1) return true;
        boolean ans=false;
        
        if(dp[i][k]!=null) return dp[i][k];
        
        if(k>0 && h.containsKey(a[i]+k)){//k>0 checking as then in next step if k is negative k-1 will become +ve which will create problems
            ans|=help(h.get(a[i]+k),a,n,k,dp);
        }
        if((k-1)>0 && h.containsKey(a[i]+(k-1))){//checking if a[i]+(k-1) is present in array or not
            ans|=help(h.get(a[i]+(k-1)),a,n,k-1,dp);
        }
        if((k+1)>0 && h.containsKey(a[i]+(k+1))){
            ans|=help(h.get(a[i]+(k+1)),a,n,k+1,dp);// if a[i]+(k+1) is present then move to h.get(a[i]+(k-1)) index and new k is k+1 (as k is prev jump units) not a[i]+(k+1)
        }
        
        return dp[i][k]=ans;
    }
}