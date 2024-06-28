class Solution {
    public long maximumImportance(int n, int[][] a) {
        int e[]=new int[n];//give max number to node with max edges
        for(int i=0;i<a.length;i++){
            e[a[i][0]]++;
            e[a[i][1]]++;
        }
        long ans=0L;
        Arrays.sort(e);
        int x=1;
        for(int i=0;i<n;i++){
            ans+=(e[i]*(long)x);
            x++;
        }
        return ans;
    }
}