class Solution {
    public String[] sortPeople(String[] a, int[] t) {
        //hashmap wont work ast here are duplicate names so use indices
        // HashMap<String,Integer>h=new HashMap<>();
        // for(int i=0;i<a.length;i++) h.put(a[i],t[i]);
        // Arrays.sort(a,(x,y)->(h.get(y)-h.get(x));
        
        int n=a.length;
        // int ind[]=new int[n];//as comparator on normal int dont work so use Integer
        Integer ind[]=new Integer[n];
        for(int i=0;i<n;i++) ind[i]=i;
        Arrays.sort(ind,(x,y)->(t[y]-t[x]));
        String ans[]=new String[n];
        for(int i=0;i<n;i++){
            ans[i]=a[ind[i]];
        }
        return ans;
    }
}