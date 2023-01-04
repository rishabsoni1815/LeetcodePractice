class Solution {
    public int minimumRounds(int[] a) {
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<a.length;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        int ans=0;
        for(int k:h.keySet()){
            int v=h.get(k);
            if(v==1) return -1;
            ans+=(v/3);
            v%=3;
            if(v==1 || v==2){//if 4->2,2 not 3,1 else always 3
                ans++;
            }
        }
        return ans;
    }
}