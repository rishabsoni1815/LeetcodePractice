class Solution {
    public int firstMissingPositive(int[] a) {
        int n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]<=0){
                a[i]=1000;//random  positive number so that where ever this is present in outr last check we return this i+1
            }
        }
        for(int i=0;i<n;i++){
            if(Math.abs(a[i])<=n && a[Math.abs(a[i])-1]>0){//need to check math.abs as duplicates are there
                a[Math.abs(a[i])-1]*=-1;
            }
        }
        for(int i=0;i<n;i++){
            if(a[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}