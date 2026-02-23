class Solution {
    public int maxProduct(int[] a) {
        int ans=Integer.MIN_VALUE,pre=1,suf=1;
        for(int i=0;i<a.length;i++){
            pre=pre*a[i];
            suf=suf*a[a.length-i-1];
            ans=Math.max(ans,Math.max(pre,suf));
            if(pre==0) pre=1;
            if(suf==0) suf=1;
        }
        return ans;
    }
}