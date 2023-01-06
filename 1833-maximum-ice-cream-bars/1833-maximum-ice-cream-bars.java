class Solution {
    public int maxIceCream(int[] a, int p) {
        Arrays.sort(a);
        int n=a.length;
        int ans=0;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            if(sum<=p){
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}