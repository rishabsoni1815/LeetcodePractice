class Solution {
    public int minCost(String s, int[] a) {
        int ans=0,n=s.length();
        for(int i=1;i<n;){
            if(s.charAt(i)==s.charAt(i-1)){
                if(a[i-1]<a[i]){
                    ans+=a[i-1];
                    i++;
                }else{
                    ans+=a[i];
                    a[i]=a[i-1];
                    i++;
                }
            }else i++;
        }
        return ans;
    }
}