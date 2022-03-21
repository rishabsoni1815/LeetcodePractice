class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer>last=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        int j=-1;
        int n=s.length();
        for(int i=0;i<n;i++){
            last.put(s.charAt(i),i);
        }
        int start=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            j=Math.max(j,last.get(c));
            if(i==j) {
                ans.add(j-start+1);
                j=-1;
                start=i+1;
            }
        }
        return ans;
    }
}