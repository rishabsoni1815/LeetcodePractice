class Solution {
    public int canCompleteCircuit(int[] g, int[] c) {
        int i=0,n=g.length,ans=0,ind=0;
        int s=0;
        for(int x:g) s+=x;
        for(int x:c) {
            s-=x;
            if(s<0) return -1;
        }
        while(i<n){
            if(ans<0){
                ans=0;
                ind=i;
            }
            ans+=g[i];
            ans-=c[i];
            i++;
        }
        return ind;
    }
}