/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int t, MountainArray a) {
        int p=getpivot(a);
        int res=-1;
        if(t>=a.get(0)&&t<=a.get(p)){
            res=bs(0,p,a,t,true);
        }
        if(res==-1){
            res=bs(p+1,a.length()-1,a,t,false);
        }
        return res;
    }
    int bs(int l,int r,MountainArray a,int t,boolean asc){
        while(l<=r){
            int m=l+(r-l)/2;
            if(a.get(m)==t) return m;
            if(a.get(m)<t){
                if(asc) l=m+1;
                else r=m-1;
            }else{
                if(asc) r=m-1;
                else l=m+1;
            }
        }
        return -1;
    }
    int getpivot(MountainArray A){
        int n=A.length();
        int lo = 1, hi = n - 2;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A.get(mi) > A.get(mi + 1) && A.get(mi) > A.get(mi - 1) ) return mi;
            if (A.get(mi) < A.get(mi + 1) && A.get(mi) > A.get(mi - 1) )
                lo = mi + 1;
            else
                hi = mi- 1;
        }
        return lo;
    }
}