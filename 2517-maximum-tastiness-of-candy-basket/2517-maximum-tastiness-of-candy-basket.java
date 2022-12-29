class Solution {
    public int maximumTastiness(int[] a, int k) {
        Arrays.sort(a);
        int r=a[a.length-1]-a[0];
        int l=0,ans=0;
        while(l<=r){
            int m=l+(r-l)/2;
            if(help(m,a,k)){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ans;
    }
    boolean help(int m,int a[],int k){
        int i=1,c=1,start=a[0];
        while(i<a.length){
            if(a[i]-start>=m){
                start=a[i];
                c++;
            }
            i++;
        }
        return c>=k;
    }
}