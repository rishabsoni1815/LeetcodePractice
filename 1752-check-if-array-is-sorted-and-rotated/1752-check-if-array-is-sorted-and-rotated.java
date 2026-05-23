class Solution {
    public boolean check(int[] a) {
        int n=a.length;
        int c=0;
        for(int i=1;i<n;i++){
if(a[i]<a[i-1]){
 c++;
}
           // if(c>0 && a[i]>a[0])return false;
            if(c>1) return false;
}
        if(a[n-1]>a[0]) c++;
        return c<=1;
    }
}
//1 2 3 4 5
//3 4 5 1 2
//4 5 1 2 3