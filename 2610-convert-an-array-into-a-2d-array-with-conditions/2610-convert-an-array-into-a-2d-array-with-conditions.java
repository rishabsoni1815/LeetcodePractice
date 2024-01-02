class Solution {
    public List<List<Integer>> findMatrix(int[] a) {
        int n=a.length;
        int freq[]=new int[n+1];
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            freq[a[i]]++;
            if(freq[a[i]]-1>=ans.size()) ans.add(new ArrayList<>());
            ans.get(freq[a[i]]-1).add(a[i]);
        }
        return ans;
    }
}