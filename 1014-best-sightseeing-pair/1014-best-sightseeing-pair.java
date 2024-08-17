class Solution {
    public int maxScoreSightseeingPair(int[] a) {
        int n=a.length;
        int maxRt[]=new int[n];
        for(int i=n-1;i>=0;i--){
            maxRt[i]=a[i]-i;
            if(i+1<n) maxRt[i]=Math.max(maxRt[i],maxRt[i+1]);
        }
        int cmax=0,ans=0;
        for(int i=0;i<n-1;i++){
            cmax=Math.max(cmax,a[i]+i);
            ans=Math.max(ans,cmax+maxRt[i+1]);
        }
        return ans;
    }
}