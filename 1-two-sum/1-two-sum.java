class Solution {
    public int[] twoSum(int[] a, int t) {
        HashMap<Integer,Integer>h=new HashMap<>();
        int ans[]=new int[2];
        for(int i=0;i<a.length;i++){
            if(h.containsKey(t-a[i])){
                ans[0]=i;
                ans[1]=h.get(t-a[i]);
                return ans;
            }
            h.put(a[i],i);
        }
        return ans;
    }
}