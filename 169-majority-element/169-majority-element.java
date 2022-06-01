class Solution {
    public int majorityElement(int[] a) {
        int ans=a[0],sum=1;
        for(int i=1;i<a.length;i++){
            if(a[i]==ans) sum++;
            else sum--;
            if(sum<0){
                sum=1;
                ans=a[i];
            }
        }
        return ans;
    }
}