class Solution {
    public int findPairs(int[] a, int k) {
        int n=a.length;
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<n;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        int ans=0;
        for(int i:h.keySet()){
            int f=h.get(i);
            if(k==0){
                if(f>1) ans++;
            }else{
                if(h.containsKey(i-k)){
                    ans++;
                }
            }
        }
        return ans;
    }
}