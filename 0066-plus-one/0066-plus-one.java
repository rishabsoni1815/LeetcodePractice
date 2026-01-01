class Solution {
    public int[] plusOne(int[] a) {
        int r=1;
        for(int i=a.length-1;i>=0;i--){
            int x=a[i]+r;
            a[i]=x%10;
            r=x/10;
        }
        if(r!=0){
            int ans[]=new int[a.length+1];
            for(int i=0;i<ans.length;i++){
                if(i==0) ans[i]=r;
                else ans[i]=a[i-1];
            }
            return ans;
        }
        return a;
    }
}