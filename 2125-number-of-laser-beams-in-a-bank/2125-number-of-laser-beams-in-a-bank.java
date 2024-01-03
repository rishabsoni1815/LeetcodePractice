class Solution {
    public int numberOfBeams(String[] a) {
        int ans=0,prev=0;
        for(int i=0;i<a.length;i++){
            int x=0;
            for(int j=0;j<a[i].length();j++){
                if(a[i].charAt(j)=='1') x++;
            }
            ans+=prev*x;
            if(x!=0) prev=x;
        }
        return ans;
    }
}