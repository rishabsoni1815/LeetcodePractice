class Solution {
    public char nextGreatestLetter(char[] a, char t) {
        int n=a.length;
        int l=0,r=n-1,ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]>t){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return a[ans];
    }
}