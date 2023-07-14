class Solution {
    public int longestSubsequence(int[] a, int d) {
        int n=a.length;
        HashMap<Integer,Integer>h=new HashMap<>();
        int ans=1;
        for(int i=0;i<n;i++){
            h.put(a[i],h.getOrDefault(a[i]-d,0)+1);  
            ans=Math.max(h.get(a[i]),ans);
        }
        return ans;
    }
}