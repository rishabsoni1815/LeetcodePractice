class Solution {
    public int findCenter(int[][] a) {
        int n=a.length;
        int h[]=new int[n+2];
        for(int i=0;i<a.length;i++){
            h[a[i][0]]++;
            h[a[i][1]]++;
        }
        for(int i=0;i<h.length;i++){
            if(h[i]==n) return i;
        }
        return -1;
    }
}