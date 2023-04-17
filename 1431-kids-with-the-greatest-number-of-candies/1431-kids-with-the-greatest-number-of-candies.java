class Solution {
    public List<Boolean> kidsWithCandies(int[] a, int t) {
        int n=a.length;
        int max=a[0];
        for(int x:a) max=Math.max(max,x);
        List<Boolean>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if((a[i]+t)>=max){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}