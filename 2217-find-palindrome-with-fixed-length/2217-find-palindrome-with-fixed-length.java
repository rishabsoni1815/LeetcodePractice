class Solution {
    public long[] kthPalindrome(int[] a, int l) {
        int n=a.length;
        long x=1;
        if(l%2==0){
        for(int i=0;i<l/2-1;i++){
            x=x*10+0;
        }
        }else{
        for(int i=0;i<l/2;i++){
            x=x*10+0;
        }
        }
        long h=(x*10 - x);
        long ans[]=new long[n];
        for(int i=0;i<n;i++){
            if(a[i]>h) {
                ans[i]=-1;
                continue;
            }
            String g=String.valueOf(a[i]+x-1);
            int j=g.length()-1;
            if(l%2!=0){
                j--;
            }
            for(;j>=0;j--) g+=g.charAt(j);
            ans[i]=Long.valueOf(g);
        }
        return ans;
    }
}