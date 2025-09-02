class Solution {
    public int numberOfPairs(int[][] a) {
        int n=a.length;
        Arrays.sort(a,(x,y)->((x[0]==y[0] ? (y[1]-x[1]) :(x[0]-y[0]) )));
        int ans=0;
        for(int i=0;i<n;i++){
            int cmax=-1;
            for(int j=i+1;j<n;j++){
                int fr=a[i][0];
                int fc=a[i][1];
                int sr=a[j][0];
                int sc=a[j][1];
                if(fc<sc) continue;//not upper left
                //if top right corner less than cur max then yes else no and update cmax now
                if(sc>cmax) {
                    cmax=sc;
                    ans++;
                }
            }
        }
        return ans;
    }
}