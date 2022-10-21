class Solution {
    public boolean containsNearbyDuplicate(int[] a, int k) {
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(h.containsKey(a[i])){
                if(Math.abs(i-h.get(a[i]))<=k) return true;
            }
            h.put(a[i],i);
        }
        return false;
    }
}