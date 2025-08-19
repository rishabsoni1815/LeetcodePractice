class Solution {
    public long zeroFilledSubarray(int[] a) {
        int n=a.length,c=0;
        long ans=0;
        for(int i=0;i<n;i++){
            if(a[i]==0) c++;
            else{
                ans+=((long)c*(c+1)/2);
                c=0;
            }
        }
        ans+=((long)c*(c+1)/2);
        return ans;
    }
}