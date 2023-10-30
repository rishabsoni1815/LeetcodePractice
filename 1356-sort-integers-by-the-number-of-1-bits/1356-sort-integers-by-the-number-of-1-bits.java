class Solution {
    public int[] sortByBits(int[] a) {
        int c[][]=new int[a.length][2];
        for(int i=0;i<a.length;i++){
            c[i][0]=a[i];
            c[i][1]=bitCnt(a[i]);
        }
        Arrays.sort(c,(x,y)->((x[1]==y[1])?(x[0]-y[0]):(x[1]-y[1])));
        for(int i=0;i<c.length;i++){
            a[i]=c[i][0];
        }
        return a;
    }
    int bitCnt(int x){
        int ans=0;
        while(x>0){
            if(x%2!=0){
                ans++;
            }
            x/=2;
        }
        return ans;
    }
}