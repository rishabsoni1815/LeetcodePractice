class Solution {
    public int countPairs(int[] a, int k) {
        int ans=0,n=a.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i]==a[j] && (i*j)%k==0 ){
                    ans++;
                }
            }
        }
        return ans;
    }
}