class Solution {
    public List<String> summaryRanges(int[] a) {
        int n=a.length;
        List<String>ans=new ArrayList<>();
        if(n==0) return ans;
        for(int i=0;i<n;i++){
            int x=a[i];
            while(i+1<n && a[i]+1==a[i+1]){
                i++;
            }
            if(x!=a[i]){
                ans.add(x+"->"+a[i]);
            }else{
                ans.add(String.valueOf(x));
            }
        }
        return ans;
    }
}