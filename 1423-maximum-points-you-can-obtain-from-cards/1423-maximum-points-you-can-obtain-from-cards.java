class Solution {
    public int maxScore(int[] a, int kk) {
        int n=a.length;
        int k=n-kk;
        int min=0;
        int sum=0;
        for(int y:a) sum+=y;
        if(kk==n) return sum;
        min=sum;
        int csum=0;
        for(int i=0;i<k-1;i++) csum+=a[i];
        for(int i=k-1;i<n;i++){
            csum+=a[i];
            // System.out.println(csum);
            min=Math.min(min,csum);
            csum-=a[i-k+1];
        }
        return sum-min;
    }
}