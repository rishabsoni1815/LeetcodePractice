class Solution {
    public boolean search(int[] a, int t) {
        //same as this - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ for test case [10 1 2 10 10] case
       // in this we just added a[i]==a[m] && a[m]==a[j] condition for https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
        
        int n=a.length;
        int l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]==t) return true;
            if(a[l]==a[m] && a[m]==a[r]){
                l++;
                r--;
                continue;  //as then next if statement will also be checked
            }
            if(a[l]<=a[m]){//left sorted
                if(t>=a[l] && t<=a[m]){//t in left sorted half so search in it
                    r=m-1;
                }else{//t not lie in left sorted half
                    l=m+1;
                }
            }else{//right sorted
                if(t>=a[m] && t<=a[r]){//t in right sorted half so search in it
                    l=m+1;
                }else{//t not lie in right sorted half
                    r=m-1;
                }
            }
        }
        return false;
    }
}