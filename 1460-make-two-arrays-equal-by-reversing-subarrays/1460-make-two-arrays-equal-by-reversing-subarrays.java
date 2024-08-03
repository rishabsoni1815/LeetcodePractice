class Solution {
    public boolean canBeEqual(int[] a, int[] b) {
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<a.length;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        for(int i=0;i<b.length;i++){
            if(h.containsKey(b[i])){
                h.put(b[i],h.get(b[i])-1);
                if(h.get(b[i])==0) h.remove(b[i]);
            }
            else return false;
        }
        return h.size()==0;
    }
}