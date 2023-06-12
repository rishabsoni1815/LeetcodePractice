class Solution {
    public List<String> summaryRanges(int[] a) {
        int n=a.length;
        List<String>ans=new ArrayList<>();
        if(n==0) return ans;
        int px=a[0],x=a[0];
        for(int i=1;i<n;i++){
            if((x+1)!=a[i]){
                if(px==x){
                    ans.add(""+x);
                }else{
                    ans.add(""+px+"->"+x);
                }
                px=a[i];
            }
            x=a[i];
        }
        
                if(px==x){
                    ans.add(""+x);
                }else{
                    ans.add(""+px+"->"+x);
                }
        return ans;
    }
}