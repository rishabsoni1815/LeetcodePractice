class Solution {
    public int maximumTop(int[] a, int k) {
        int n=a.length;
        if(k==0){
            if(n>=1) return a[0];
            else return -1;
        }if(k==1){
            if(n>=2) return a[1];
            return -1;
        }if(n==1){
            if(k%2==0) return a[0];
            return -1;
        }
        //max of k-1 elements
        int maxi=0;
        for(int i=0;i<Math.min(n,k-1);i++)maxi=Math.max(maxi,a[i]);
        if(k<n){ //as if k<=n then we can't take out all k and check as we won't be able to put the max back
            maxi= Math.max(maxi,a[k]);
        }
        //else if k==n the  also max of all k if k>n then also max of all array(think with cases (we will put and unput max and second max))
        return maxi;
    }
}