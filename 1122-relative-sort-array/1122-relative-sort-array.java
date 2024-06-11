class Solution {
    public int[] relativeSortArray(int[] a, int[] b) {
        int h1[]=new int[1004];
        int ans[]=new int[a.length];
        for(int i=0;i<a.length;i++){
            h1[a[i]]++;
        }
        int j=0;
        for(int i=0;i<b.length;i++){
            while(h1[b[i]]-->0){
                ans[j++]=b[i];
            }
        }
        for(int i=0;i<h1.length;i++){
             while(h1[i]-->0){
                ans[j++]=i;
            }
        }
        return ans;
    }
}