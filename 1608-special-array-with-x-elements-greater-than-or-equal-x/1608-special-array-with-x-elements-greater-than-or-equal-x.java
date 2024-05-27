class Solution {
    public int specialArray(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        for(int i=0;i<=a[n-1];i++){//till max elemetn
            if(find(a,n,i)) return i;
        }
        return -1;
    }
    boolean find(int a[],int n,int k){//finding smallest(want >= than k) index of k
        int l=0,r=n-1,ans=n;
        while(l<=r){
            int m=(l+(r-l)/2);
            if(a[m]>=k){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        if((n-ans)==k) return true;
        return false;
    }
}