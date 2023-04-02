class Solution {
    public int[] successfulPairs(int[] a, int[] b, long s) {
        Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            int x=(int)Math.ceil((double)s/a[i]);
            a[i]=help(b,x);
        }
        return a;
    }
    int help(int a[],int x){
        int l=0,r=a.length-1;
        int ans=a.length;
        while(l<=r){
            int m=(l+(r-l)/2);
            if(a[m]>=x){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return a.length-ans;
    }
}