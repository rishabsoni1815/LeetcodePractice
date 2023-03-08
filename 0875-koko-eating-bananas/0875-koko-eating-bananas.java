class Solution {
    public int minEatingSpeed(int[] a, int h) {
        int n=a.length;
        int max=a[0];
        for(int x:a) max=Math.max(max,x);
        int l=0,r=max,ans=max;
        while(l<=r){
            int m=l+(r-l)/2;
            if(h(m,a,h)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean h(int m,int a[],int h){
        int k=0;
        for(int i=0;i<a.length;i++){
            k+=(Math.ceil((double)a[i]/m));
            if(k>h) return false;
        }
        return true;
    }
}