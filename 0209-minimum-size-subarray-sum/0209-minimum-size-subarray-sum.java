class Solution {
    public int minSubArrayLen(int t, int[] a) {
        int n=a.length;
        //subarray   ---->   two pointer approach works most of times 
        //also check sliding window types
        int i=0,j=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(j<n&&i<n){
            sum+=a[j];
           while(sum>=t){
                ans=Math.min(ans,j+1-i);
                sum-=a[i];
                i++;
            }
             j++;
            //System.out.println(sum+" "+ans+" "+i+" "+j);
        }
         return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}