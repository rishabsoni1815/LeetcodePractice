class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        int min=Integer.MAX_VALUE;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            int diff=Math.abs(a[i]-a[i-1]);
                if(diff<=min){
                    if(diff<min){
                        min=diff;
                        ans.clear();
                    }
                      ans.add(Arrays.asList(a[i-1], a[i]));
                }
        }
        return ans;
    }
}