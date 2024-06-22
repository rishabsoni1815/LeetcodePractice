class Solution {
    public int numberOfSubarrays(int[] a, int k) {
        int n=a.length;
        HashMap<Integer,Integer>h=new HashMap<>();
        h.put(0,1);
        int c=0,ans=0;
        for(int i=0;i<n;i++){
            if(a[i]%2!=0) c++;
            if(h.containsKey(c-k)){
                ans+=h.get(c-k);
            }
            h.put(c,h.getOrDefault(c,0)+1);
        }
        return ans;
    }
}