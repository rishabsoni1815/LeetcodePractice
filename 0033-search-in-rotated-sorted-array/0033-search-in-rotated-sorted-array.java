class Solution {
    public int search(int[] a, int t) {
        //option1 - find min in sorted rotated then search in left/right half acc to condition in which target lies
        //optio 2- direct check if which side is sorted and if t lies in it or not then apply cases
        int n=a.length;
        int l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]==t) return m;
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
        return -1;
    }
}