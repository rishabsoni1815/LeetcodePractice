class Solution {
    public long maxRunTime(int c, int[] a) {
        int n=a.length;
        long l=0,r=0,ans=0;
        for(int y:a) r+=y;
        r/=c;
        while(l<=r){
            long m=l+(r-l)/2;
            if(help(m,c,a)){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ans;
    }
    boolean help(long m,int c,int a[]){
        long res=0L;
        for(int i=0;i<a.length;i++){
            if(a[i]>m){
                res+=m;
            }else{
               res+=a[i]; 
            }
        }
        res/=c;
        return res>=m;
    }
}