class Solution {
    public boolean isNStraightHand(int[] a, int k) {
        Arrays.sort(a);
        HashMap<Integer,Integer>h=new HashMap<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(h.containsKey(a[i])==false) continue;
            if(h.containsKey(a[i])){
                for(int j=0;j<k;j++){
                    if(h.containsKey(a[i]+j)==false) return false;
                    h.put(a[i]+j,h.get(a[i]+j)-1);
                    if(h.get(a[i]+j)==0) h.remove(a[i]+j);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}