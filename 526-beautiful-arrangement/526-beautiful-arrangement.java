class Solution {
    public int countArrangement(int n) {
        boolean v[]=new boolean[n];
       return help(n,1,v);
    }
    int help(int n,int k,boolean v[]){
        if(k>n) return 1;
        int ans=0;
        for(int j=1;j<=n;j++){
            if(v[j-1]) continue;
            if(k%j==0 || j%k==0){
                v[j-1]=true;
                ans+=help(n,k+1,v);
                v[j-1]=false;
            }
        }
        return ans;
    }
}