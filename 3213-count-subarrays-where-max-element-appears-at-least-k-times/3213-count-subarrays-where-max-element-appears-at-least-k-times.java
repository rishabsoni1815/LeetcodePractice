class Solution {
    public long countSubarrays(int[] a, int k) {
        int n=a.length;
        int l=0,r=0,c=0,max=-1;
        long ans=0;
        for(int f:a) max=Math.max(max,f);
        while(r<n){
            if(a[r]==max) c++;
            while(c>=k && l<=r){
                ans+=(n-r);
                if(a[l]==max) c--;
                l++;
            }
            r++;
        }
        return ans;
    }
}