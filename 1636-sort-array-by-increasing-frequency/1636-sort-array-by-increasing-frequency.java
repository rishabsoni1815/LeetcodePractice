class Solution {
    public int[] frequencySort(int[] a) {
        HashMap<Integer,Integer>h=new HashMap<>();
        Integer t[]=new Integer[a.length];
        for(int i=0;i<a.length;i++){
            t[i]=a[i];
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        Arrays.sort(t,(x,y)->(h.get(x)==h.get(y))? (y-x):(h.get(x)-h.get(y)));
        for(int i=0;i<a.length;i++) a[i]=t[i];
        return a;
    }
}