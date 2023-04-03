class Solution {
    public int numRescueBoats(int[] a, int l) {
        Arrays.sort(a);
        int i=0,j=a.length-1;
        int ans=0;
        while(i<=j){
            if(a[i]+a[j] <=l){
                i++;
                j--;
                ans++;
            }else if(a[j]<=l){
                j--;
                ans++;
            }
        }
        return ans;
    }
}