class Solution {
    public int majorityElement(int[] a) {
        int cans=a[0],ans=a[0];
        int sum=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==cans){
                sum++;
            }
            else{
                sum--;
                if(sum==0){
                    sum=1;
                    ans=a[i];
                    cans=a[i];   
                }
            }
        }
        int csum=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==ans){
                csum++;
            }
        }
        if(csum>=(a.length/2)) return ans;
        return -1;
    }
}