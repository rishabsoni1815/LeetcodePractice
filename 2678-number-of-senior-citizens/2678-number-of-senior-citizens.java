class Solution {
    public int countSeniors(String[] a) {
        int n=a.length,ans=0;
        for(int i=0;i<n;i++){
            if(Integer.valueOf(a[i].substring(11,13))>60) ans++;
        }
        return ans;
    }
}