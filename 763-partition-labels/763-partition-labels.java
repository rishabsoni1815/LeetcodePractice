class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer>last=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        int j=-1;
        int n=s.length();
        for(int i=0;i<n;i++){
            last.put(s.charAt(i),i);//remebering the last occurance of a char so that when we encounter it then we can ask will it come in future if yes then continue else add the ans to list 
        }
        int start=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            j=Math.max(j,last.get(c));//this is before the check if i==j as for a case ababcbacadefegehijhklij d only occurs once so we have to update it before checking i==j
            if(i==j) {
                ans.add(j-start+1);
                j=-1;
                start=i+1;
            }
        }
        return ans;
    }
}