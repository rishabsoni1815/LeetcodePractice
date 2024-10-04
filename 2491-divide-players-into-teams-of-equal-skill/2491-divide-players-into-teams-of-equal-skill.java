class Solution {
    public long dividePlayers(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        long ans=a[0]*a[n-1];
        int sum=a[0]+a[n-1];
        for(int i=1;i<n/2;i++){
            if(sum!=(a[i]+a[n-i-1])) return -1;
            else{
                ans=(ans+(a[i]*a[n-i-1]));
            }
        }
        return ans;
    }
}
