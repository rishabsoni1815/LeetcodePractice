class Solution {
    public boolean asteroidsDestroyed(int m, int[] a) {
        Arrays.sort(a);
        int n=a.length;
        if(n==1){
            return (m>=a[0]);
        }
       long pre=m;
        for(int i=0;i<n;i++){
            if(pre<a[i]) return false;
            pre+=a[i];
        }
        return true;
    }
}