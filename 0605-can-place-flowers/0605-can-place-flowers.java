class Solution {
    public boolean canPlaceFlowers(int[] a, int k) {
        int i=0,ans=0,n=a.length;
        while(i<n){
            if(a[i]==1){
                i++;
            }else{
                boolean f=true;
                if(i>0){
                    if(a[i-1]==1) f=false;
                }
                if(i< n-1){
                    if(a[i+1]==1) f=false;
                }
                if(f==true){
                    ans++;
                    i++;
                }
            }
            i++;
        }
        return k<=ans;
    }
}