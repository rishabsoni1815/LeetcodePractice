class Solution {
    public int minimizedMaximum(int n, int[] a) {
        int max=0;
        for(int x:a){
            max=Math.max(max,x);
        }
        int l=1,r=max,ans=r;
        while(l<=r){
            int m=l+(r-l)/2;
            if(help(a,n,m)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean help(int a[],int n,int m){
        int cnt=0;
        for(int i=0;i<a.length;i++){
            int x=a[i]/m;
            cnt+=x;
            if(a[i]%m!=0) cnt++;
            if(cnt>n) return false;
        }
        return true;
    }
}
