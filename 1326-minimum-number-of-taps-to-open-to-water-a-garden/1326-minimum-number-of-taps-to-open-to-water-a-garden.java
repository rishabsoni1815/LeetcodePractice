class Solution {
    public int minTaps(int n, int[] r) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,n+2);//filling with max as taking min in loops below
         dp[0] = 0;               // minimum tapes needed to water area 0 is 0(basically no area)
        for(int i=0;i<=n;i++)  
        {
            int left = Math.max(0,i-r[i]);     // find the minimum point of garden(area) to water with tape i.
            int right = Math.min(n,i+r[i]);       // find the maximum point of garden(area) to water with tape i.
            for(int j=left+1;j<=right;j++)   
            {                
                //Check if this range from(left..right) can be watered using less number of tapes than previous and do 1 (this tap) +dp[left] (taps from 0 to left position)
                dp[j] = Math.min(dp[j], dp[left]+1); 
            }
        }
        
        // If mimimum tapes needed to water area 0..n is greater than n , it means we could not found minimum number of tapes
        if(dp[n]>=n+2)   
            return -1;
        return dp[n];       
    }
}