class Solution {
    public long maxMatrixSum(int[][] a) {
        //if all -ve cnt is odd the only move - to min in whooe matric else if even then all can cencel out so same sum
        //since if there is 1 ele with -ve sigh we can move it to any other ele in the whole matrix
        long sum=0L;
        int cnt=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                int abs=(int)Math.abs(a[i][j]);
                min=Math.min(min,abs);
                sum+=(long)(abs);
                if(a[i][j]<0) {
                    cnt++;
                }
            }
        }
        if(cnt%2!=0){
            sum-=2*min;
        }
        return sum;
    }
}