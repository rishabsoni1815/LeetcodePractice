class Solution {
    public int minimumAverageDifference(int[] a) {
        long min=Integer.MAX_VALUE;
        long sum=0;int ans=0;
        for(int x:a)sum+=x;
        long csum=0;
        for(int i=0;i<a.length;i++){
            csum+=a[i];
            long y=0;
            if(i!=a.length-1) y=(sum-csum)/(a.length-i-1);
            long c=Math.abs((csum/(i+1))-y);
            if(c<min){
                min=c;
                ans=i;
            }
        }
        return ans;
    }
}