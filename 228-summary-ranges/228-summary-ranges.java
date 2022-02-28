class Solution {
    public List<String> summaryRanges(int[] a) {
        int n=a.length;
        List<String>ans=new ArrayList<>();
        if(n==0) return ans;
        int prev=a[0];
        int i=0;
        while(i<n){
            int cur=prev;
            i++;
            while(i<n && a[i]==prev+1){
                prev=a[i];
                i++;
            }
            if(cur!=prev) ans.add(cur+"->"+prev);
            else ans.add(""+cur);
            if(i==n) break;
            prev=a[i];
        }
        return ans;
    }
}