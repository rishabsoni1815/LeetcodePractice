class Solution {
    public int maximumScore(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        
        
//         i, j is the index of the left side and the right side corresponding.
// k is the number of elements that we picked.
// leftPicked: is the number of elements picked on the left side, leftPicked = i.
// rightPicked: is the number of elements picked on the right side, rightPicked = k - leftPicked = k - i.
// Finally: r = n - rightPicked - 1 = n - (k-i) - 1.
        
        
        Integer dp[][]=new Integer[m][m];//n*n will give tle so as i can go only till m and k also till m so we will derive j from k,i
        
        return help(0,0,m,a,b,n,dp);
    }
    int help(int i,int k,int m,int a[],int b[],int n,Integer dp[][]){
        int j=n-(k-i)-1;
        if(k==m) return 0;
        if(dp[i][k]!=null) return dp[i][k];
        return dp[i][k]=Math.max(a[i]*b[k]+help(i+1,k+1,m,a,b,n,dp),a[j]*b[k]+help(i,k+1,m,a,b,n,dp));
    }
}