class Solution {
    public int[] countBits(int n) {
          int a[]=new int[n+1];
        /*
        
4	100
5	101
6	110
7	111
8	1000 --> 4(100) and add 0 at last = 8(1000) so a[k] increase k and then a[k]
9	1001 --> 4(100) and add 1 at last = 9(1001) so a[k]+1 
10	1010
11	1011
12	1100
13	1101
14	1110
15	1111
        
        */
          int k=0;
        for(int i=1;i<=n;i++){
            if(i%2==0) {
                k++;
                a[i]=a[k];
            }
            else {
                a[i]=1+a[k];
            }
        }
        return a;
    }
}