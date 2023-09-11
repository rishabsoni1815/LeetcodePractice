class Solution {
    public List<List<Integer>> groupThePeople(int[] a) {
        int n=a.length;
        HashMap<Integer,List<Integer>>h=new HashMap<>();
        for(int i=0;i<n;i++){
            if(h.containsKey(a[i])){
                h.get(a[i]).add(i);
            }else{
                List<Integer>g=new ArrayList<>();
                g.add(i);
                h.put(a[i],g);
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int k:h.keySet()){
            List<Integer>c=h.get(k);
            List<Integer>temp=new ArrayList<>();
            int s=0;
            while(s<c.size()){
                temp.add(c.get(s));
                s++;
                if(s%k==0){
                    ans.add(new ArrayList<>(temp));
                    temp=new ArrayList<>();
                }
            }
        }
        return ans;
    }
}