class Solution {
    public long minimumRemoval(int[] a) {
        long ans=Long.MAX_VALUE;int n=a.length;
        // making all as 0 or a[i] for every i then ans will be min of ans or ((total sum)-(number of players greater than or equals to a[i])*(a[i])) so to find number of players greater than or equals to a[i] we will use sorting as lets say a[i] is 4 and a after sorting is a[]={1,4,5,6} and after making all to 4 array will look like a[]={0,4,4,4} which is {-1,0,-1,-2} which is 16-(3*4) = 4 where 3 is number of i's greater than and equal to 4 and 16 is sum of all i's in array
        Arrays.sort(a);long sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,(sum-((n-i)*(long)a[i])));
        }
        return ans;
    }
}