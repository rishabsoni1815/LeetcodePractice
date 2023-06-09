class Solution {
    public char nextGreatestLetter(char[] a, char t) {
        int n=a.length;
        int i=0,j=n-1,ans=-1;
        while(i<=j){
            int m=i+(j-i)/2;
            if(a[m]>t){
                ans=m;
                j=m-1;
            }else{
                i=m+1;
            }
        }
        if(ans==-1) return a[0];
        else return a[ans];
    }
}