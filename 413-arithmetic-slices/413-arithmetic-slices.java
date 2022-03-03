class Solution {
    //o(n^2)
    // public int numberOfArithmeticSlices(int[] a) {
    //     int n=a.length;
    //     if(n<=2) return 0;
    //     int dp[]=new int[n];
    //     for(int i=2;i<n;i++){
    //         dp[i]=dp[i-1];
    //         int c=1,diff=a[i]-a[i-1];
    //         for(int j=i;j>0;j--){
    //             if(a[j]-a[j-1] == diff) c++;
    //             else break;
    //         }
    //         if(c>=3) dp[i]+=(c-2);
    //     }
    //     return dp[n-1];
    // }
    
   // o(n)
    /*
      // if A[i-2], A[i-1], A[i] are arithmetic, then the number of arithmetic slices ending with A[i] (dp[i]) equals to: the number of arithmetic slices ending with A[i-1] (dp[i-1], all these arithmetic slices appending A[i] are also arithmetic) + A[i-2], A[i-1], A[i] (a brand new arithmetic slice) so  dp[i] = dp[i-1] + 1 
    
    */
    public int numberOfArithmeticSlices(int[] A) {
       int []dp=new int[A.length];//dp[i] -> no of subarrays ending at i
    int count=0;    
    for(int i=2;i<A.length;i++)
    {
        if(A[i] - A[i-1] == A[i-1] - A[i-2])
        {
           dp[i]=dp[i-1]+1;       
           count+=dp[i]; 
        }
    }   
     return count;  
    }
}