class Solution {
    public int numberOfBeams(String[] a) {
        int ans=0;
        int n=a.length;int x=0,y=0;
        for(int i=0;i<a[0].length();i++){
            if(a[0].charAt(i)=='1')x++;
        }
        for(int i=1;i<n;i++){
            y=0;
            for(int j=0;j<a[i].length();j++){
                if(a[i].charAt(j)=='1'){
                   y++;
                }
            }
            if(y==0) continue;
            ans+=(x*y);
            x=y;
        }
        return ans;
    }
}