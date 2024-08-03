class Solution {
    public int minSwaps(int[] a) {
        int ans=Integer.MAX_VALUE,cnt=a[0],n=a.length,l=0,r=0,cntO=0;
        for(int i=0;i<n;i++) cntO+=a[i];
        while(l<n){
            if(l!=0) cnt-=a[l-1];
            while(r-l+1 < cntO){
                r++;
                cnt+=(a[r%n]);
            }
            ans=Math.min(ans,cntO-cnt);
            l++;
        }
        return ans;
    }
}