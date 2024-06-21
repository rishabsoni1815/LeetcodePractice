class Solution {
    public int maxSatisfied(int[] a, int[] g, int m) {
        int n=a.length;
        int csum=0;
        int tpre[]=new int[n];//taking all sum so can m length consecutive sum at any time
        for(int i=0;i<n;i++){
            if(i-1>=0) tpre[i]=tpre[i-1];
            tpre[i]+=a[i];
        }
        int zpre[]=new int[n];//taking all 0's sum so can sum other than this m length consecutive sum at any time
        int totalz=0;
        for(int i=0;i<n;i++){
            if(i-1>=0) zpre[i]=zpre[i-1];
            if(g[i]==0) {
                zpre[i]+=a[i];
                totalz+=a[i];
            }
        }
        //so my total ans for this m is -> tottal m sum (tpre[i]-tpre[i-m]) + total 0 sum other than 0 in this m (totalz - (zpre[i]-zpre[i-m]));
        int ans=0;
        for(int i=m-1;i<n;i++){
            int totalsum=tpre[i];
            if(i-m>=0) totalsum-=tpre[i-m];
            int zsum=zpre[i];
            if(i-m>=0) zsum-=zpre[i-m];
           int cans=(totalsum) + (totalz-zsum);
            // System.out.println(totalsum+" "+(totalz-zsum)+" "+cans+" "+i);
            ans=Math.max(ans,cans);
        }
        return ans;
    }
}