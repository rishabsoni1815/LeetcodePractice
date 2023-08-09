class Solution {
        public int findMin(int[] a) {
        //https://www.youtube.com/watch?v=nhEMDKMB44g&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=7 -> Find Minimum in Rotated Sorted Array this falis for [10 1 10 10 10] so whenever this comes i++ j--
        int n=a.length;
        int i=0,j=n-1,ans=Integer.MAX_VALUE;
        while(i<=j){
            int m=i+(j-i)/2;
            if(a[i]==a[m] && a[m]==a[j]){
                ans=Math.min(ans,a[m]);
                i++;
                j--;
                continue;  //as then next if statement will also be checked
            }
            if(a[i]<=a[m]){
                ans=Math.min(ans,a[i]);//if left half is sorted see in right half but update ans with min of left half i.e. a[i]
                i=m+1;
            }else{
                ans=Math.min(ans,a[m]);//if right half is sorted see in left half but update ans with min of right half i.e. a[m]
                j=m-1;
            }
        }
        return ans;
    }
}