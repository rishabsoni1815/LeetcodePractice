class Solution {
    public int maxOperations(int[] a, int t) {
        HashMap<Integer,Integer>h=new HashMap<>();
        int ans=0;
        for(int i=0;i<a.length;i++){
            if(h.containsKey(t-a[i])){
                ans++;
                h.put((t-a[i]),h.get(t-a[i])-1);//as can't use this t-a[i] again
                if(h.get(t-a[i])==0) h.remove(t-a[i]);//imp
            }else{
                h.put(a[i],h.getOrDefault(a[i],0)+1);//else as can't use this a[i] again (as it formed pait with t-a[i]) so can't inc freq
            }
        }
        return ans;
    }
}