class Solution {
    public int longestSubarray(int[] a) {
        int n=a.length;
        int c=0,ans=0,p=0,i=0;
        while(i<n){
            int z=0;
            while(i<n && a[i]==0){
                z++;
                i++;
            }
            ans=Math.max(ans,p+c);
            if(z==1){
                p=c;
                c=0;
            }else if(z>1){
                p=0;
                c=0;
            }
            if(i<n) c+=a[i];
            i++;
        }
        if(c==n) return n-1;
        ans=Math.max(ans,p+c);
        return ans;
    }
}