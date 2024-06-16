class Solution {
    public int minPatches(int[] a, int n) {
        long max=0,ans=0;int i=0;
        while(max<n){
            if(i<a.length && max+1>=a[i]){
                //max formed till now is = or > a[i] so just go ahead ans new max is now max+=a[i]
                max+=a[i];
                i++;
            }else {
                max+=(max+1);
                ans++;//patch applied and max we can form till now is max + new max (max+1) so max+max+1 is the new max 
            }
        }
        return (int)ans;
    }
}