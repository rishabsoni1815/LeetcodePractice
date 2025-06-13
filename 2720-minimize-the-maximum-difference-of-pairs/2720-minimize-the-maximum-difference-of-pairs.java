class Solution {
    public int minimizeMax(int[] a, int p) {
        int n=a.length;
        Arrays.sort(a);
        int l=0,r=a[n-1]-a[0],ans=0;
        while(l<=r){
            int m = l+(r-l)/2;
            if(help(m,a,p)){
                ans=m;
                r=m-1;
            }else l=m+1;
        }
        return ans;
    }

    boolean help(int m,int a[],int p){
        int cnt=0;
        for(int i=1;i<a.length;i++){
            if(a[i]-a[i-1] <= m) {
                cnt++;
                i++;
            } 
        }
        return cnt>=p;
    }
}