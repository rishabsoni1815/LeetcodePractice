class Solution {
    public int chalkReplacer(int[] a, int k) {
        long sum=0L;
        for(int y:a) sum+=y;
        long kk=k%sum;
        for(int i=0;i<a.length;i++){
            if(kk-a[i]<0) return i; 
            kk-=a[i];
        }
        return 0;
    }
}