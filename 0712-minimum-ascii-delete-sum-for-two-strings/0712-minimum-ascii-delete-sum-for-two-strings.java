class Solution {
    public int minimumDeleteSum(String a, String b) {
        int n=a.length(),m=b.length();
        Integer dp[][]=new Integer[n+1][m+1];
        return help(0,0,n,m,a,b,dp);
    }
    int help(int i,int j,int n,int m,String a,String b,Integer dp[][]){
        if(i>=n && j>=m) return 0;
        else if(i>=n || j>=m){//imp if one finished other left add all left sum
            if(i<n){
                int x=0;
                for(int k=i;k<n;k++){
                    x+=a.charAt(k);
                }
                return dp[i][j]=x;
            }else{
                int x=0;
                for(int k=j;k<m;k++){
                    x+=b.charAt(k);
                }
                return dp[i][j]=x;
            }
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return help(i+1,j+1,n,m,a,b,dp);
        }else{
            int o1=((int)(a.charAt(i)+b.charAt(j))+help(i+1,j+1,n,m,a,b,dp));
            int o2=((int)(a.charAt(i))+help(i+1,j,n,m,a,b,dp));
            int o3=((int)(b.charAt(j))+help(i,j+1,n,m,a,b,dp));
            return dp[i][j]=Math.min(o1,Math.min(o2,o3));
        }
    }
}