class Solution {
    public List<List<Integer>> groupThePeople(int[] a) {
        int n=a.length;
        HashMap<Integer,List<Integer>>h=new HashMap<>();
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!h.containsKey(a[i])){
                h.put(a[i],new ArrayList<>());
            }
            List<Integer>g=h.get(a[i]);
            g.add(i);
            if(g.size()==a[i]){
                ans.add(g);
                h.put(a[i],new ArrayList<>());
            }
        }
        return ans;
    }
}