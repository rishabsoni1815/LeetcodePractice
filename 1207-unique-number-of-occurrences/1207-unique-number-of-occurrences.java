class Solution {
    public boolean uniqueOccurrences(int[] a) {
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<a.length;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        HashSet<Integer>set=new HashSet<>();
        for(int key:h.keySet()){
            if(set.contains(h.get(key))) return false;
            set.add(h.get(key));
        }
        return true;
    }
}