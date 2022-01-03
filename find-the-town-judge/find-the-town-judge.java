class Solution {
    public int findJudge(int n, int[][] t) {
        int in[]=new int[n];
        int ou[]=new int[n];
        
        for(int i=0;i<t.length;i++){
            in[t[i][1]-1]++;
            ou[t[i][0]-1]++;
        }
        for(int i=0;i<n;i++){
            if(in[i]==n-1&&ou[i]==0) return i+1;
        }
        return -1;
    }
}