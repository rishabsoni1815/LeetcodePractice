class Solution {
    public int minDeletionSize(String[] a) {
        int n=a.length,m=a[0].length(),ans=0;
        for(int i=0;i<m;i++){
            char c=a[0].charAt(i);
            for(int j=1;j<n;j++){
                if(a[j].charAt(i)<c) {
                    ans++;
                    break;
                }
                c=a[j].charAt(i);
            }
        }
        return ans;
    }
}