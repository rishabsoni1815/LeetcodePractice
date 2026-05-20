class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int cnt=0,n=a.length;
        int h[]=new int[n+1];
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            h[a[i]]++;
            if(h[a[i]]>1) cnt++;
            h[b[i]]++;
            if(h[b[i]]>1) cnt++;
            ans[i]=cnt;
        }
        return ans;
    }
}