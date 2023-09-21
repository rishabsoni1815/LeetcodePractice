class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        // fact that median is (sum of max on left and min on right)/2 of the cut in sorted array
        if(a.length>b.length){
            int t[]=a;
            a=b;
            b=t;
        }
        int n=a.length;
        int m=b.length;
        int l=0;//min no. from 1st arr we can pick(choosing from arr 1 as first cut will be dreived from l and r)
        int h=n;//max no. from 1st arr we can pick
        while(l<=h){
            int c1=(l+h)/2;
            int c2=((n+m)/2)-c1;//considering n+m to be even (n+m)/2 is the total that should be on left of cut and also on right of cut of median
            int l1=c1==0?Integer.MIN_VALUE:a[c1-1];
            int l2=c2==0?Integer.MIN_VALUE:b[c2-1];
            int r1=c1==n?Integer.MAX_VALUE:a[c1];
            int r2=c2==m?Integer.MAX_VALUE:b[c2];
            if(l1>r2){
                h=c1-1;
            }else if(l2>r1){
                l=c1+1;
            }else{
                return (n+m)%2==0 ? ((Math.max(l1,l2)+Math.min(r1,r2))/2.0) :  Math.min(r1,r2);//if odd Math.min(r1,r2) as 2nd half (with r1 and r2 ) will always have more elements in case of odd n+m as n<m always 
                
                //2.0 not 2 for double value
            }
        }
       return -1;
    }
}