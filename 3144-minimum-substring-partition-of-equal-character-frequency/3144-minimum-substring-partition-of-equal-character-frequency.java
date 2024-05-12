class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n=s.length();
        if(n==1) return 1;
        if(n==2) return 1;
        int dp[]=new int[n];
        int h[][]=new int[26][n];//made prefix of hash as o(n^3) was exceeding
        calc(h,s);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n;i++){
            dp[i]=i+1;
            for(int j=i;j>=0;j--){
                if(check(j,i,h)) {
                    dp[i]=Math.min(dp[i],1+(j!=0 ? dp[j-1]:0));
                }
            }
        }
        return dp[n-1];
    }
    boolean check(int ii,int jj,int cnt[][]){
        int h[]=new int[26];
        for(int k=0;k<26;k++){
            h[k]=cnt[k][jj];
           if(ii-1>=0) h[k]-=cnt[k][ii-1];
        }
        int c=-1;
        for(int i=0;i<26;i++){
            if(h[i]!=0 && c==-1){
                c=h[i];
                continue;
            }
            if(h[i]!=0 && c!=-1){
                if(h[i]!=c) return false;        
            }
        }
        return true;
    }
    void calc(int h[][],String s){
        for(int j=0;j<h[0].length;j++){
            for(int i=0;i<h.length;i++){
                if(j!=0) h[i][j]=h[i][j-1];
            }
            int x=s.charAt(j)-'a';
            h[x][j]++;
        }
    }
}