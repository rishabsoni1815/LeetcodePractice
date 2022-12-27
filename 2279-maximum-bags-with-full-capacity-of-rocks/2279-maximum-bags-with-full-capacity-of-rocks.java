class Solution {
    public int maximumBags(int[] c, int[] r, int k) {
        int n=c.length;
        for(int i=0;i<n;i++){
            c[i]=c[i]-r[i];
        }
        Arrays.sort(c);
        int i=0;
        while(i<n){
            // System.out.println(c[i]+" "+k);
            if(k-c[i]>=0){
                k-=c[i];
                i++;
            }else{
                return i;
            }
        }
        return n;
    }
}