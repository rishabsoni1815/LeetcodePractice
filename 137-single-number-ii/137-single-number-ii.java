class Solution {
    public int singleNumber(int[] a) {
        /*
        
        count set bits at every bit of all numbers(32 as size of int is 32) and if the count of set bits is not a multiple of 3 that means our final element will be 1 here else 0 
        
        */
        int n=a.length;int ans=0;
        for(int i=0;i<32;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(((1<<i) & a[j]) != 0){//not >0 as negative number's and can be -ve
                    c++;
                }
            }
            if(c%3==1){
                ans|=(1<<i);
            }
        }
        return ans;
    }
}