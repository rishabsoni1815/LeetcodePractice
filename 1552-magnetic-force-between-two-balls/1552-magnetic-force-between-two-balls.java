class Solution {
    public int maxDistance(int[] a, int k) {
        Arrays.sort(a);//imp for check fn
        int max=0,n=a.length;
        for(int i=0;i<n;i++){
            max=Math.max(a[i],max);
        }
        int l=0,r=max+1,ans=r;
        while(l<=r){
            int m=l+(r-l)/2;
            if(check(m,a,k)){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ans;
    }
    boolean check(int m,int a[],int k){
        int prev=a[0];
        k--;
        for(int i=1;i<a.length;i++){
            if((a[i]-prev)>=m){
                k--;
                prev=a[i];
            }
        }
        return k<=0;
    }
}