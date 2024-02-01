class Solution {
    public int[][] divideArray(int[] a, int k) {
        Arrays.sort(a);
        int ans[][]=new int[a.length/3][3];
        for(int i=0;i<a.length;i++){
            if((i!=0 && ((i+1)%3)==0) && (a[i]-a[i-2]>k)) return new int[0][0];
            ans[i/3][i%3]=a[i];
        }
        return ans;
    }
}