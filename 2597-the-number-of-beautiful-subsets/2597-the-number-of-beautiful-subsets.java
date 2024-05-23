class Solution {
    public int beautifulSubsets(int[] a, int k) {
        int n=a.length;
        //as duplicates alo possible
        Arrays.sort(a);
        // HashSet<Integer>h=new HashSet<>();//as duplicates can be threr so if i remove 4 there maybe others 4too so take map and od h[4]--
        HashMap<Integer,Integer>h=new HashMap<>();
        return help(a,k,h,0)-1;
    }
    int help(int a[],int k,HashMap<Integer,Integer>h,int i){
        if(i==a.length) return 1;
        int ans=0;
        if(!h.containsKey(a[i]-k) && !h.containsKey(k+a[i])){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
            ans+=help(a,k,h,i+1);
            h.put(a[i],h.get(a[i])-1);
            if(h.get(a[i])==0) h.remove(a[i]);
        }
        ans+=help(a,k,h,i+1);
        return ans;
    }
}   