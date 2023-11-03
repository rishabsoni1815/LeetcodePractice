class Solution {
    public List<String> buildArray(int[] a, int n) {
        List<String>ans=new ArrayList<>();
        int x=1;
        for(int i=0;i<a.length;){
            if(a[i]!=x){
                ans.add("Push");
                ans.add("Pop");
            }
            else {
                ans.add("Push");
                i++;
            }
            x++;
        }
        return ans;
    }
} 