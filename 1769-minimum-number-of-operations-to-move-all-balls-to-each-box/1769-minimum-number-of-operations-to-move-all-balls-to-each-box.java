class Solution {
    public int[] minOperations(String a) {
        int n=a.length();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(a.charAt(j)=='1'){
                    c+=Math.abs(j-i);
                }
            }
            ans[i]=c;
        }
        return ans;
    }
}