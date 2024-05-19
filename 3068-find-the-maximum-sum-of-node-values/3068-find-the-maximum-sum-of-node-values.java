class Solution {
    public long maximumValueSum(int[] a, int k, int[][] e) {
        long sum=0,cnt=0,minInside=Integer.MAX_VALUE,minOutside=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if((a[i]^k)>a[i]){
                sum+=(a[i]^k);
                cnt++;
                minInside=Math.min(minInside,(long)(a[i]^k)-a[i]);
            }else{
                sum+=(a[i]);
                minOutside=Math.min(minOutside,(long)a[i]-(a[i]^k));
            }
        }
        if(cnt%2==0) return sum;
        //odd then else leave inside ones or take that and take outside's min
        if(minOutside<minInside){
            return sum-minOutside;
        }else{
            return sum-minInside;
        }
    }
}