class Solution {
    public int minDistance(String a, String b) {
        int n=a.length(),m=b.length();
        Integer dp[][]=new Integer[n][m];
        return help(n-1,m-1,a,b,dp);
    }
    int help(int i,int j,String a,String b,Integer dp[][]){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=null) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
           return dp[i][j]=help(i-1,j-1,a,b,dp);
        }else{
            int x=help(i,j-1,a,b,dp);//insert -> inserted jth char after a.substring(0,i+1) so is is same only but as jth is matched (insertd jth char only) so j--
            int y=help(i-1,j,a,b,dp);//delete -> deleted ith char but still hve to match jth so i-- but j is same
            int z=help(i-1,j-1,a,b,dp);//replace-> replaced ith with jth so  i-- j--
            return dp[i][j]=1+Math.min(x,Math.min(y,z));
        }
    }
}