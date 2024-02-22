class Solution {
    public int findJudge(int n, int[][] a) {
        int trustCount[]=new int[n+1];
        int whoTrust[]=new int[n+1];
        for(int i=0;i<a.length;i++){
            trustCount[a[i][1]]++;
            whoTrust[a[i][0]]=a[i][1];
        }
        for(int i=1;i<=n;i++){
            if(trustCount[i]==(n-1) && whoTrust[i]==0) return i;
        }
        return -1;
    }
}