class Solution {
    public int longestSubarray(int[] a, int limit) {
        int n=a.length;
        TreeMap<Integer,Integer>h=new TreeMap<>();//tree map as duplicates can be there so map tree map as need max and min both in log n time at one point
        int l=0,r=0,ans=0;
        while(r<n){
            h.put(a[r],h.getOrDefault(a[r],0)+1);
            while(l<r && h.lastKey()-h.firstKey()>limit){
                h.put(a[l],h.get(a[l])-1);
                if(h.get(a[l])==0) h.remove(a[l]);
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}